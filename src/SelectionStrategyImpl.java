import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 选择策略实现
 */
public class SelectionStrategyImpl implements GeneticAlgorithmStrategy {

    /**
     * 单例模式
     */
    private static final SelectionStrategyImpl INSTANCE = new SelectionStrategyImpl();


    /**
     * 防止外部创建实例
     */
    private SelectionStrategyImpl() {
    }

    @Override
    public List<Chromosome> calculate(List<Chromosome> chromosomes, double probability) {
        ArrayList<Chromosome> sonGroup = new ArrayList<>();
        int totalFitness = 0;
        double[] fitness = new double[chromosomes.size()];
        for (Chromosome chromosome : chromosomes) {
            totalFitness += ChromosomeHelper.calcFitness(chromosome.getX(), chromosome.getY());
        }
        int index = 0;
        //计算适应度
        for (Chromosome chromosome : chromosomes) {
            fitness[index] =
                    ChromosomeHelper.calcFitness(chromosome.getX(), chromosome.getY()) / ((double) totalFitness);
            index++;
        }
        //计算累加适应度
        for (int i = 1; i < fitness.length; i++) {
            fitness[i] = fitness[i - 1] + fitness[i];
        }
        //轮盘赌选择
        for (int i = 0; i < 20; i++) {
            Random random = new Random();
            probability = random.nextDouble();
            int choose;
            for (choose = 1; choose < fitness.length - 1; choose++) {
                if (probability < fitness[choose]) {
                    break;
                }
            }
            sonGroup.add(new Chromosome(chromosomes.get(choose).getGene()));
        }
        return sonGroup;
    }

    public static SelectionStrategyImpl getInstance() {
        return INSTANCE;
    }
}
