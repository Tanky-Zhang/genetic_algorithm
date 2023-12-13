import java.util.List;

/**
 * 染色体工具类
 */
public class ChromosomeHelper {

    /**
     * 获取最优染色体
     */
    public static Chromosome best(List<Chromosome> group) {
        Chromosome bestOne = group.get(0);
        for (Chromosome c : group) {
            if (calcFitness(c.getX(), c.getY()) > calcFitness(bestOne.getX(), bestOne.getY())) {
                bestOne = c;
            }
        }
        return bestOne;
    }

    public static int calcFitness(int x, int y) {
        return x * x + y * y;
    }

}
