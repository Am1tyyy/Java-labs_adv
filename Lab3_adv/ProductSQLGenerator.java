public class ProductSQLGenerator {
    public static String generateInsertSQL(Product product) {
        return String.format("INSERT INTO products (id, name, price) VALUES ('%s', '%s', %.2f);",
                product.getId(), product.getName(), product.getPrice());
    }

    public static String generateUpdateSQL(Product product, String whereClause) {
        return String.format("UPDATE products SET name = '%s', price = %.2f WHERE %s;",
                product.getName(), product.getPrice(), whereClause);
    }

    public static String generateDeleteSQL(String whereClause) {
        return String.format("DELETE FROM products WHERE %s;", whereClause);
    }
}
