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

        // Generate SQL using Reflection
        System.out.println("Using Reflection:");
        System.out.println(SQLGenerator.generateInsertSQL(user));
        System.out.println(SQLGenerator.generateInsertSQL(product));
        System.out.println(SQLGenerator.generateInsertSQL(order));
        
        // Generate SQL without Reflection
        System.out.println("\nWithout Reflection:");
        long startWithoutReflection = System.nanoTime();
        System.out.println(ManualSQLGenerator.generateInsertSQL(user));
        long endWithoutReflection = System.nanoTime();

        // Time Measurement for Reflection
        long startWithReflection = System.nanoTime();
        System.out.println(SQLGenerator.generateInsertSQL(user));
        long endWithReflection = System.nanoTime();

        System.out.println("\nExecution Time (Without Reflection): " + (endWithoutReflection - startWithoutReflection) + " ns");
        System.out.println("Execution Time (With Reflection): " + (endWithReflection - startWithReflection) + " ns");
    }
}
