class ManualSQLGenerator {
    public static String generateInsertSQL(User user) {
        return String.format("INSERT INTO users (id, username, email) VALUES ('%d', '%s', '%s');",
                user.getId(), user.getUsername(), user.getEmail());
    }
}