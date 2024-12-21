public class UserSQLGenerator {
    public static String generateInsertSQL(User user) {
        return String.format("INSERT INTO users (id, username, email) VALUES ('%s', '%s', '%s');",
                user.getId(), user.getUsername(), user.getEmail());
    }

    public static String generateUpdateSQL(User user, String whereClause) {
        return String.format("UPDATE users SET username = '%s', email = '%s' WHERE %s;",
                user.getUsername(), user.getEmail(), whereClause);
    }

    public static String generateDeleteSQL(String whereClause) {
        return String.format("DELETE FROM users WHERE %s;", whereClause);
    }
}
