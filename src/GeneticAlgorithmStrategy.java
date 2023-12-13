import java.util.List;

/**
 * 定义抽象的策略接口
 */
public interface GeneticAlgorithmStrategy {

    /**
     * 定义了计算策略所拥有的算法
     */
    List<Chromosome> calculate(List<Chromosome> chromosomes, double probability);

}
