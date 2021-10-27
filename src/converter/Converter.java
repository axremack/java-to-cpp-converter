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
            System.out.print("Fields : ");
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

    public void fetchConstructors(){
        for (Constructor constructor : constructors) {
            System.out.print("Constructors : ");
            String[] constructorString = constructor.toGenericString().split(" ");

            String access = constructorString[0];
            String name_and_args = constructorString[1];

            System.out.print("access - " + access);
            System.out.println(" // name and args - " + name_and_args);
        }
        System.out.println();
    }

    public void fetchMethods(){
        for (Method method : methods) {
            System.out.print("Method : ");
            String[] methodString = method.toGenericString().split(" ");

            String access = methodString[0];
            String return_type = methodString[1];
            String name_and_args = methodString[2];

            System.out.print("access - " + access);
            System.out.print(" // return type - " + return_type);
            System.out.println(" // name and args - " + name_and_args);
        }
        System.out.println();
    }


}
