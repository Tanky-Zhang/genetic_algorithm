/**
 * 工厂模式的顶层抽象
 */
public interface Factory {

    /*定义一个生成策略的接口，其参数还可以使用一个配置文件来实现约束条件，这里使用了枚举*/
    GeneticAlgorithmStrategy createStrategy(StrategyEnum strategyEnum);

}
