import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

class SQLGenerator {

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
}
