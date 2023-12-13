import java.util.List;

/**
 * 门面模式
 */
public class FacadeContext {

    /*门面模式不参与子系统的逻辑，所以对子系统进行了一次封装*/
    private final Factory factory = new StrategyFactory();
    private final GeneticAlgorithmStrategyContext context = new GeneticAlgorithmStrategyContext(null);

    public FacadeContext() {
    }

    public List<Chromosome> calculate(List<Chromosome> chromosomes, double probability, StrategyEnum strategy) {
        this.context.setStrategy(this.factory.createStrategy(strategy));
        return this.context.execute(chromosomes, probability);
    }

}
