# Typed SQL Generators

This project demonstrates how to generate SQL statements using Java classes and methods. The main goal is to provide a simple way of creating SQL queries for user, product, and order-related operations. It uses string formatting to insert values into SQL query templates.

## Classes

### 1. `UserSQLGenerator`
The `UserSQLGenerator` class generates SQL queries related to users, including insert, update, and delete operations.
- **Methods:**
  - `generateInsertSQL(User user)` - Generates an SQL query for inserting a new user.
  - `generateUpdateSQL(User user, String whereClause)` - Generates an SQL query for updating a user’s information based on a `whereClause`.
  - `generateDeleteSQL(String whereClause)` - Generates an SQL query for deleting a user based on a `whereClause`.

### 2. `ProductSQLGenerator`
The `ProductSQLGenerator` class generates SQL queries related to products.
- **Methods:**
  - `generateInsertSQL(Product product)` - Generates an SQL query for inserting a new product.
  - `generateUpdateSQL(Product product, String whereClause)` - Generates an SQL query for updating a product’s information based on a `whereClause`.
  - `generateDeleteSQL(String whereClause)` - Generates an SQL query for deleting a product based on a `whereClause`.

### 3. `OrderSQLGenerator`
The `OrderSQLGenerator` class generates SQL queries related to orders.
- **Methods:**
  - `generateInsertSQL(Order order)` - Generates an SQL query for inserting a new order.
  - `generateUpdateSQL(Order order, String whereClause)` - Generates an SQL query for updating an order based on a `whereClause`.
  - `generateDeleteSQL(String whereClause)` - Generates an SQL query for deleting an order based on a `whereClause`.

## Example Classes

The following example classes represent entities in a typical e-commerce system:

- **User**: Represents a user with fields such as `id`, `username`, and `email`.
- **Product**: Represents a product with fields such as `id`, `name`, and `price`.
- **Order**: Represents an order with fields such as `id`, `userId`, and `productId`.

These classes are used as input to the SQL generator methods.

## Example Usage

### Main Class
The `Main` class demonstrates how to use the SQL generator methods.

```java
public class Main {
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
