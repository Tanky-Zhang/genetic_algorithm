import java.util.List;

/**
 * 策略对象封装
 */
public class GeneticAlgorithmStrategyContext {

    /*封装了策略对象*/
    private GeneticAlgorithmStrategy strategy;

    public GeneticAlgorithmStrategyContext(GeneticAlgorithmStrategy strategy) {
        this.strategy = strategy;
    }

    /*实现了策略可以互换的功能*/
    public void setStrategy(GeneticAlgorithmStrategy strategy) {
        this.strategy = strategy;
    }

    public List<Chromosome> execute(List<Chromosome> chromosomes, double probability) {
        return this.strategy.calculate(chromosomes, probability);
    }

}
