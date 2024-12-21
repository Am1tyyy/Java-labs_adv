public class OrderSQLGenerator {
    public static String generateInsertSQL(Order order) {
        return String.format("INSERT INTO orders (id, user_id, product_id) VALUES ('%s', '%s', '%s');",
                order.getId(), order.getUserId(), order.getProductId());
    }

    public static String generateUpdateSQL(Order order, String whereClause) {
        return String.format("UPDATE orders SET user_id = '%s', product_id = '%s' WHERE %s;",
                order.getUserId(), order.getProductId(), whereClause);
    }

    public static String generateDeleteSQL(String whereClause) {
        return String.format("DELETE FROM orders WHERE %s;", whereClause);
    }
}