package java1;

import java.time.LocalDate;

public class ChthonicBeing {
    private final String name;
    private final String type;
    private final LocalDate firstMentionDate;
    private final int attackPower;

    public ChthonicBeing(String name, String type, LocalDate firstMentionDate, int attackPower) {
        this.name = name;
        this.type = type;
        this.firstMentionDate = firstMentionDate;
        this.attackPower = attackPower;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public LocalDate getFirstMentionDate() {
        return firstMentionDate;
    }

    public int getAttackPower() {
        return attackPower;
    }

    @Override
    public String toString() {
        return String.format("ChthonicBeing{name='%s', type='%s', firstMentionDate=%s, attackPower=%d}",
                name, type, firstMentionDate, attackPower);
    }
}
