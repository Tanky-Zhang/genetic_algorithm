import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 交叉策略实现
 */
public class CrossoverStrategyImpl implements GeneticAlgorithmStrategy {

    /**
     * 单例模式
     */
    private static final CrossoverStrategyImpl INSTANCE = new CrossoverStrategyImpl();

    /**
     * 防止外部创建实例
     */
    private CrossoverStrategyImpl() {
    }

    @Override
    public List<Chromosome> calculate(List<Chromosome> chromosomes, double probability) {
        //生成子代种群，包含父代种群，因为父代种群也可能被选中
        ArrayList<Chromosome> sonGroup = new ArrayList<>(chromosomes);
        Random random = new Random();
        for (int k = 0; k < chromosomes.size() / 2; k++) {
            //交叉过程种出现突变
            if (probability > random.nextDouble()) {
                int i, j;
                do {
                    i = random.nextInt(chromosomes.size());
                    j = random.nextInt(chromosomes.size());
                } while (i == j);
                int position = random.nextInt(Chromosome.GEN_LENGTH);
                String parent1 = chromosomes.get(i).getGene();
                String parent2 = chromosomes.get(j).getGene();
                //双亲都有可能产生突变
                String son1 = parent1.substring(0, position) + parent2.substring(position);
                String son2 = parent2.substring(0, position) + parent1.substring(position);
                sonGroup.add(new Chromosome(son1));
                sonGroup.add(new Chromosome(son2));
            }
        }
        return sonGroup;
    }

    public static CrossoverStrategyImpl getInstance() {
        return INSTANCE;
    }
}
