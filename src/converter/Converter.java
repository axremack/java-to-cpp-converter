package converter;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Converter {
    public Class classToConvert;

    private Field[] fields;
    private Constructor[] constructors;
    private Method[] methods;

    public Converter(Class classToConvert) {
        this.classToConvert = classToConvert;
        this.fields = classToConvert.getDeclaredFields();
        this.methods = classToConvert.getDeclaredMethods();
        this.constructors = classToConvert.getDeclaredConstructors();
    }

    public void fetchFields(){
        for (Field field : fields) {
            System.out.print("Field : ");
            String[] fieldString = field.toGenericString().split(" ");
            String access = fieldString[0];
            String type = fieldString[1];
            String name = fieldString[2];
            System.out.print("access - " + access);
            System.out.print(" // type - " + type);
            System.out.println(" // name - " + name);
        }
        System.out.println();
    }


}
