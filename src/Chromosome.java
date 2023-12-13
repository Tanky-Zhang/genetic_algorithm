import java.util.ArrayList;
import java.util.Random;

/**
 * 染色体类
 */
public class Chromosome {
    public static final int GEN_LENGTH = 14;
    public static final int MAX_X = 127;
    public static final int MAX_Y = 127;
    private int x, y;
    private String gene;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getGene() {
        return gene;
    }

    /**
     * 通过x,y坐标构造染色体
     * x，y 共同组成一对染色体
     */
    public Chromosome(int x, int y) {
        if (x > MAX_X || y > MAX_Y || x < 0 || y < 0) {
            return;
        }
        this.x = x;
        this.y = y;
        String tem = Integer.toBinaryString(x);

        for (int i = tem.length(); i < GEN_LENGTH / 2; i++) {
            tem = "0" + tem;
        }
        gene = tem;
        tem = Integer.toBinaryString(y);
        for (int i = tem.length(); i < GEN_LENGTH / 2; i++) {
            tem = "0" + tem;
        }
        gene = gene + tem;
    }

    public Chromosome(String gene) {
        if (gene.length() != Chromosome.GEN_LENGTH) {
            return;
        }
        this.gene = gene;
        String xStr = gene.substring(0, Chromosome.GEN_LENGTH / 2);
        String yStr = gene.substring(Chromosome.GEN_LENGTH / 2);
        this.x = Integer.parseInt(xStr, 2);
        this.y = Integer.parseInt(yStr, 2);

    }

    public String toString() {
        return "x:" + x + "\ty:" + y + "\tgene:" + gene;
    }

    public void selfMutation(String newGene) {
        if (newGene.length() != Chromosome.GEN_LENGTH) {
            return;
        }
        this.gene = newGene;
        String xStr = newGene.substring(0, Chromosome.GEN_LENGTH / 2);
        String yStr = newGene.substring(Chromosome.GEN_LENGTH / 2);
        this.x = Integer.parseInt(xStr, 2);
        this.y = Integer.parseInt(yStr, 2);
    }

    /**
     * 用二进制表示基因序列：01001010101010
     * 如果有突变就由0变成1或者由1变成0
     * 初始化种群
     */
    public static ArrayList<Chromosome> initGroup(int size) {
        ArrayList<Chromosome> list = new ArrayList<Chromosome>();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            int x = random.nextInt() % 128;
            int y = random.nextInt() % 128;
            x = x < 0 ? (-x) : x;
            y = y < 0 ? (-y) : y;
            list.add(new Chromosome(x, y));
        }
        return list;
    }
}