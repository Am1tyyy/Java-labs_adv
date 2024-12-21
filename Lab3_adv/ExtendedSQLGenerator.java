// Extended CRUD SQL Generator

import java.lang.reflect.*;
import java.util.*;

public class ExtendedSQLGenerator {

    public static String generateInsertSQL(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();

        if (!clazz.isAnnotationPresent(Table.class)) {
            throw new IllegalArgumentException("The class " + clazz.getSimpleName() + " is not annotated with @Table.");
        }

        Table table = clazz.getAnnotation(Table.class);
        String tableName = table.name();

        List<String> columns = new ArrayList<>();
        List<String> values = new ArrayList<>();

        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Column.class)) {
                Column column = field.getAnnotation(Column.class);
                columns.add(column.name());

                field.setAccessible(true);
                values.add("'" + field.get(obj) + "'");
            }
        }

        return String.format("INSERT INTO %s (%s) VALUES (%s);",
                tableName, String.join(", ", columns), String.join(", ", values));
    }

    public static String generateSelectSQL(Class<?> clazz) {
        if (!clazz.isAnnotationPresent(Table.class)) {
            throw new IllegalArgumentException("The class " + clazz.getSimpleName() + " is not annotated with @Table.");
        }

        Table table = clazz.getAnnotation(Table.class);
        String tableName = table.name();

        List<String> columns = new ArrayList<>();

        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Column.class)) {
                Column column = field.getAnnotation(Column.class);
                columns.add(column.name());
            }
        }

        return String.format("SELECT %s FROM %s;",
                String.join(", ", columns), tableName);
    }

    public static String generateUpdateSQL(Object obj, String whereClause) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();

        if (!clazz.isAnnotationPresent(Table.class)) {
            throw new IllegalArgumentException("The class " + clazz.getSimpleName() + " is not annotated with @Table.");
        }

        Table table = clazz.getAnnotation(Table.class);
        String tableName = table.name();

        List<String> setClauses = new ArrayList<>();

        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Column.class)) {
                Column column = field.getAnnotation(Column.class);
                field.setAccessible(true);
                setClauses.add(column.name() + " = '" + field.get(obj) + "'");
            }
        }

        return String.format("UPDATE %s SET %s WHERE %s;",
                tableName, String.join(", ", setClauses), whereClause);
    }

    public static String generateDeleteSQL(Class<?> clazz, String whereClause) {
        if (!clazz.isAnnotationPresent(Table.class)) {
            throw new IllegalArgumentException("The class " + clazz.getSimpleName() + " is not annotated with @Table.");
        }

        Table table = clazz.getAnnotation(Table.class);
        String tableName = table.name();

        return String.format("DELETE FROM %s WHERE %s;", tableName, whereClause);
    }
}
