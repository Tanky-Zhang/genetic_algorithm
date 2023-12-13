/**
 * 封装策略的枚举
 */
public enum StrategyEnum {

    MUTATION("MUTATION", MutationStrategyImpl.getInstance()),

    CROSSOVER("CROSSOVER", CrossoverStrategyImpl.getInstance()),

    SELECTION("SELECTION", SelectionStrategyImpl.getInstance());

    private final String strategyName;

    private final GeneticAlgorithmStrategy strategy;

    StrategyEnum(String strategyName, GeneticAlgorithmStrategy strategy) {
        this.strategyName = strategyName;
        this.strategy = strategy;
    }

    public String getStrategyName() {
        return this.strategyName;
    }

    public GeneticAlgorithmStrategy getStrategy() {
        return this.strategy;
    }
}
