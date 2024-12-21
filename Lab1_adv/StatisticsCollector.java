package java1;
import java.util.ArrayList;

public class StatisticsCollector extends ArrayList<ChthonicBeing> {
    private int minAttack = Integer.MAX_VALUE;
    private int maxAttack = Integer.MIN_VALUE;
    private double sumAttack = 0;
    private double sumSquared = 0;
    private int count = 0;

    @Override
    public boolean add(ChthonicBeing being) {
        int attack = being.getAttackPower();
        minAttack = Math.min(minAttack, attack);
        maxAttack = Math.max(maxAttack, attack);
        sumAttack += attack;
        sumSquared += Math.pow(attack, 2);
        count++;
        return super.add(being);
    }

    public int getMinAttack() {
        return minAttack;
    }

    public int getMaxAttack() {
        return maxAttack;
    }

    public double getAverageAttack() {
        return count == 0 ? 0 : sumAttack / count;
    }

    public double getStdDevAttack() {
        if (count == 0) return 0;
        double mean = getAverageAttack();
        return Math.sqrt((sumSquared / count) - Math.pow(mean, 2));
    }
}
