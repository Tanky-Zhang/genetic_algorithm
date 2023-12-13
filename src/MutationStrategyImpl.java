import java.util.List;
import java.util.Random;

/**
 * 突变策略实现
 */
public class MutationStrategyImpl implements GeneticAlgorithmStrategy {

    /**
     * 单例模式
     */
    private static final MutationStrategyImpl INSTANCE = new MutationStrategyImpl();

    /**
     * 防止外部创建实例
     */
    private MutationStrategyImpl() {
    }

    @Override
    public List<Chromosome> calculate(List<Chromosome> chromosomes, double probability) {
        Random random = new Random();
        Chromosome bestOne = ChromosomeHelper.best(chromosomes);
        chromosomes.add(new Chromosome(bestOne.getGene()));
        for (Chromosome c : chromosomes) {
            //获取到基因序列
            String newGene = c.getGene();
            for (int i = 0; i < newGene.length(); i++) {
                if (probability > random.nextDouble()) {
                    //产生突变
                    String newChar = newGene.charAt(i) == '0' ? "1" : "0";
                    newGene = newGene.substring(0, i) + newChar + newGene.substring(i + 1);
                }
            }
            //突变后的基因序列重新赋值
            c.selfMutation(newGene);
        }
        return null;
    }

    public static MutationStrategyImpl getInstance() {
        return INSTANCE;
    }
}
