/**
 * 工厂实现
 */
public class StrategyFactory implements Factory {

    @Override
    public GeneticAlgorithmStrategy createStrategy(StrategyEnum strategyEnum) {
        return strategyEnum.getStrategy();
    }
}
