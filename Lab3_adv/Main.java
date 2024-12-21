class Main {
    public static void main(String[] args) {
        User user = new User("1", "john_doe", "john@example.com");
        Product product = new Product("101", "Laptop", 1200.00);
        Order order = new Order("1001", "1", "101");

        // User SQL Generation
        System.out.println(UserSQLGenerator.generateInsertSQL(user));
        System.out.println(UserSQLGenerator.generateUpdateSQL(user, "id = '1'"));
        System.out.println(UserSQLGenerator.generateDeleteSQL("id = '1'"));

        // Product SQL Generation
        System.out.println(ProductSQLGenerator.generateInsertSQL(product));
        System.out.println(ProductSQLGenerator.generateUpdateSQL(product, "id = '101'"));
        System.out.println(ProductSQLGenerator.generateDeleteSQL("id = '101'"));

        // Order SQL Generation
        System.out.println(OrderSQLGenerator.generateInsertSQL(order));
        System.out.println(OrderSQLGenerator.generateUpdateSQL(order, "id = '1001'"));
        System.out.println(OrderSQLGenerator.generateDeleteSQL("id = '1001'"));
    }
}