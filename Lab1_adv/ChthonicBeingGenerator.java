package java1;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ChthonicBeingGenerator {

    public static void main(String[] args) {
        // Generate the stream of chthonic beings
        Stream<ChthonicBeing> beingsStream = generateInfiniteBeings();

        // Number of objects to skip
        int skipCount = 100;

        // Generate and process the list of beings
        List<ChthonicBeing> beings = beingsStream
                .filter(being -> !being.getType().equalsIgnoreCase("Ghost"))
                .skip(skipCount)
                .limit(500)
                .collect(Collectors.toList());

        // Filter by years since first mention
        int minYears = 100;
        int maxYears = 500;
        Map<String, List<ChthonicBeing>> groupedByType = beings.stream()
                .filter(being -> {
                    int yearsSinceFirstMention = Period.between(being.getFirstMentionDate(), LocalDate.now()).getYears();
                    return yearsSinceFirstMention >= minYears && yearsSinceFirstMention <= maxYears;
                })
                .collect(Collectors.groupingBy(ChthonicBeing::getType));

        // Collect statistics
        StatisticsCollector statsCollector = new StatisticsCollector();
        beings.stream().collect(Collectors.toCollection(() -> statsCollector));
        System.out.printf("Min Attack: %d, Max Attack: %d, Avg Attack: %.2f, Std Dev: %.2f%n",
                statsCollector.getMinAttack(), statsCollector.getMaxAttack(), statsCollector.getAverageAttack(), statsCollector.getStdDevAttack());

        // Identify outliers
        AttackOutlierAnalyzer outlierAnalyzer = new AttackOutlierAnalyzer(beings);
        System.out.println(outlierAnalyzer.analyzeOutliers());
    }

    private static Stream<ChthonicBeing> generateInfiniteBeings() {
        Random random = new Random();
        List<String> names = Arrays.asList("Azazel", "Charybdis", "Banshee", "Djinn", "Kraken");
        List<String> types = Arrays.asList("Demon", "Spirit", "Monster", "Ghost", "Wraith");
        return IntStream.iterate(1, i -> i + 1)
                .mapToObj(i -> {
                    String name = names.get(random.nextInt(names.size()));
                    String type = types.get(random.nextInt(types.size()));
                    LocalDate firstMentionDate = LocalDate.now().minusYears(random.nextInt(1000));
                    int attackPower = random.nextInt(100) + 1;
                    return new ChthonicBeing(name, type, firstMentionDate, attackPower);
                });
    }
}
