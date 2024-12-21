# Java Annotations and Reflection Example

## Project Overview
This project demonstrates the use of custom annotations and reflection in Java to dynamically generate SQL queries for Create-Read-Update-Delete (CRUD) operations. The implementation includes:

1. **Custom Annotations**: `@Table` and `@Column` for mapping Java classes and fields to database tables and columns.
2. **Reflection**: To inspect annotations at runtime and dynamically generate SQL queries.
3. **Manual SQL Generation**: A comparison example that generates SQL without using reflection.
4. **Performance Measurement**: Time comparisons between reflection-based and non-reflection-based approaches.

### Descriptions
- **`annotations`**: Contains the `@Table` and `@Column` annotations for marking classes and fields.
- **`entities`**: Includes example entity classes `User`, `Product`, and `Order`.
- **`utils`**: Implements `SQLGenerator` for reflection-based SQL generation and `ManualSQLGenerator` for non-reflection SQL generation.
- **`main`**: Contains the `Main` class for demonstrating the functionality.

## Example Output

```
Using Reflection:
INSERT INTO users (id, username, email) VALUES ('1', 'john_doe', 'john@example.com');
INSERT INTO products (id, name, price) VALUES ('101', 'Laptop', '1200.0');
INSERT INTO orders (id, user_id, product_id) VALUES ('1001', '1', '101');

Without Reflection:
INSERT INTO users (id, username, email) VALUES ('1', 'john_doe', 'john@example.com');

Execution Time (Without Reflection): 14490400 ns
Execution Time (With Reflection): 277000 ns
```

## Author
[Borodai Vladyslav]

## License
This project is licensed under the MIT License. See `LICENSE` for details.

