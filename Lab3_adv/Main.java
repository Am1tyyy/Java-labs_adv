public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        User user = new User();
        user.setId(1);
        user.setUsername("john_doe");
        user.setEmail("john@example.com");

        Product product = new Product();
        product.setId(101);
        product.setName("Laptop");
        product.setPrice(1200.00);

        Order order = new Order();
        order.setId(1001);
        order.setUserId(1);
        order.setProductId(101);

        // SQL через рефлексію
        System.out.println("With reflection:");
        long startWithReflection = System.nanoTime();
        System.out.println(SQLGenerator.generateInsertSQL(user));
        long endWithReflection = System.nanoTime();

        // SQL без рефлексії
        System.out.println("\nWithout reflection:");
        long startWithoutReflection = System.nanoTime();
        System.out.println(ManualSQLGenerator.generateInsertSQL(user));
        long endWithoutReflection = System.nanoTime();

        // Вимір часу
        System.out.println("\nTime (reflection): " + (endWithReflection - startWithReflection) + " ns");
        System.out.println("Time (without reflection): " + (endWithoutReflection - startWithoutReflection) + " ns");
    }
}