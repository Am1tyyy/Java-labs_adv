package java1;
import java.util.*;
import java.util.stream.Collectors;

public class AttackOutlierAnalyzer {
    private final List<ChthonicBeing> beings;

    public AttackOutlierAnalyzer(List<ChthonicBeing> beings) {
        this.beings = beings;
    }

    public Map<String, Integer> analyzeOutliers() {
        List<Integer> attackPowers = beings.stream()
                .map(ChthonicBeing::getAttackPower)
                .sorted()
                .collect(Collectors.toList());

        int q1 = attackPowers.get(attackPowers.size() / 4);
        int q3 = attackPowers.get(3 * attackPowers.size() / 4);
        int iqr = q3 - q1;
        int lowerBound = q1 - 1 * iqr;
        int upperBound = q3 + 1 * iqr;

        Map<String, Integer> result = new HashMap<>();
        result.put("data", (int) beings.stream().filter(being -> {
            int attack = being.getAttackPower();
            return attack >= lowerBound && attack <= upperBound;
        }).count());
        result.put("outliers", (int) beings.stream().filter(being -> {
            int attack = being.getAttackPower();
            return attack < lowerBound || attack > upperBound;
        }).count());

        return result;
    }
}