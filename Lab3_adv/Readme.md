# SQL Generator for Java Annotations

## Author
- **Name**: [Vladyslav Borodai]

## Description
This project demonstrates a utility class `SQLGenerator` that generates SQL `INSERT` and `SELECT` statements from Java objects annotated with custom annotations `@Table` and `@Column`. It leverages reflection to extract the necessary metadata and generate the SQL statements dynamically.

Additionally, a manual version `ManualSQLGenerator` is provided to show how SQL queries can be generated without using reflection.

### Annotations Used:
- `@Table`: Specifies the table name for a Java class.
- `@Column`: Specifies the column name for a class field.

## Example Classes
1. **User Class**:
   - Represents a `users` table.
   - Fields: `id`, `username`, `email` with corresponding annotations.
   
2. **Product Class**:
   - Represents a `products` table.
   - Fields: `id`, `name`, `price` with corresponding annotations.

3. **Order Class**:
   - Represents an `orders` table.
   - Fields: `id`, `user_id`, `product_id` with corresponding annotations.

## Instructions

### Setup and Build
1. Clone this repository:
   ```bash
   git clone [repository URL]
   cd [repository-name]
