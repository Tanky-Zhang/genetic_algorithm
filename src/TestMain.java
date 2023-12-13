import java.util.List;

/**
 * 测试类
 */
public class TestMain {

    public static void main(String[] args) {
        //族群的初始大小
        final int GROUP_SIZE = 20;
        //变异率
        final double MUTATION_P = 0.01;
        //初始化
        List<Chromosome> group = Chromosome.initGroup(GROUP_SIZE);
        Chromosome theBest;
        FacadeContext context = new FacadeContext();
        //do while循环，直到找到最优解，假设32258是最佳适应度
        do {
            //交叉
            group = context.calculate(group, MUTATION_P, StrategyEnum.CROSSOVER);
            //突变
            context.calculate(group, MUTATION_P, StrategyEnum.MUTATION);
            //选择
            group = context.calculate(group, MUTATION_P, StrategyEnum.SELECTION);
            //每次经过交叉、突变、选择后，找到当前最优解
            theBest = ChromosomeHelper.best(group);
            //打印当前最优解的适应度
            System.out.println(ChromosomeHelper.calcFitness(theBest.getX(), theBest.getY()));
        } while (ChromosomeHelper.calcFitness(theBest.getX(), theBest.getY()) < 32258);
    }

}
