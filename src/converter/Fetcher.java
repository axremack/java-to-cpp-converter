package converter;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Fetcher {
    private Class classToConvert;

    private Field[] fields;
    private Constructor[] constructors;
    private Method[] methods;

    private List<Map<String,String>> allFieldsInfos;
    private List<Map<String,String>> allConstructorsInfos;
    private List<Map<String,String>> allMethodsInfos;

    private List<String> dependancies;

    // Constructor
    public Fetcher(Class classToConvert) {
        this.classToConvert = classToConvert;
        this.fields = classToConvert.getDeclaredFields();
        this.methods = classToConvert.getDeclaredMethods();
        this.constructors = classToConvert.getDeclaredConstructors();
        this.allFieldsInfos = new ArrayList<>();
        this.allConstructorsInfos = new ArrayList<>();
        this.allMethodsInfos = new ArrayList<>();
        this.dependancies = new ArrayList<>();
    }

    // Getters and setters
    public Class getClassToConvert() { return classToConvert; }
    public void setClassToConvert(Class classToConvert) { this.classToConvert = classToConvert; }

    public Field[] getFields() { return fields; }
    public void setFields(Field[] fields) { this.fields = fields; }

    public Constructor[] getConstructors() { return constructors; }
    public void setConstructors(Constructor[] constructors) { this.constructors = constructors; }

    public Method[] getMethods() { return methods; }
    public void setMethods(Method[] methods) { this.methods = methods; }

    public List<Map<String,String>> getAllFieldsInfos() { return allFieldsInfos; }
    public void setAllFieldsInfos(List<Map<String,String>> fieldInfos) { this.allFieldsInfos = fieldInfos; }

    public List<Map<String, String>> getAllConstructorsInfos() { return allConstructorsInfos; }
    public void setAllConstructorsInfos(List<Map<String, String>> allConstructorsInfos) { this.allConstructorsInfos = allConstructorsInfos; }

    public List<Map<String, String>> getAllMethodsInfos() { return allMethodsInfos; }
    public void setAllMethodsInfos(List<Map<String, String>> allMethodsInfos) { this.allMethodsInfos = allMethodsInfos; }

    public List<String> getDependancies() { return dependancies; }
    public void setDependancies(List<String> dependancies) { this.dependancies = dependancies; }

    // Methods
    public String getCPPEquivalence(String type) {
        String convertedType = type;

        if(type.equals("java.lang.String")) {
            if (!dependancies.contains("#include <string>")) dependancies.add("#include <string>");
            convertedType = "std::string";
        }
        else if (type.equals("java.lang.Integer")) {
            convertedType = "int";
        }
        else if (type.equals("java.lang.Double")) {
            convertedType = "double";
        }
        else if (type.equals("java.lang.Float")) {
            convertedType = "float";
        }

        return convertedType;
    }

    public String getEquivalenceOfList(String types) {
        StringBuilder sb = new StringBuilder();

        if (!types.isEmpty()) {
            String[] listTypes = types.split(",");

            for (int i = 0; i < listTypes.length - 1; i++) {
                String convertedType = getCPPEquivalence(listTypes[i]);
                sb.append(convertedType + ", ");
            }
            String convertedType = getCPPEquivalence(listTypes[listTypes.length - 1]);
            sb.append(convertedType);
        }

        return sb.toString();
    }

    public void fetchFields(){
        for (Field field : fields) {
            String[] fieldString = field.toGenericString().split(" ");

            String access = fieldString[0];
            String type = fieldString[1];
            String name = fieldString[2];

            Map<String, String> fieldInfos = new HashMap<String, String>(){{
                put("access", access);
                put("type", getCPPEquivalence(type));
                put("name", name);
            }};

            allFieldsInfos.add(fieldInfos);
        }
    }

    public void fetchConstructors(){
        for (Constructor constructor : constructors) {
            String[] constructorString = constructor.toGenericString().split(" ");

            String access = constructorString[0];
            String[] name_and_args = constructorString[1].split("[(]");
            String name = name_and_args[0];
            String args = (name_and_args[1].length() > 1 ) ? name_and_args[1].split("[)]")[0] : "";


            Map<String, String> constructorInfos = new HashMap<String, String>(){{
                put("access", access);
                put("name", name);
                put("arguments", getEquivalenceOfList(args));
            }};

            allConstructorsInfos.add(constructorInfos);
        }
    }

    public void fetchMethods(){
        for (Method method : methods) {
            String[] methodString = method.toGenericString().split(" ");

            String access = methodString[0];
            String return_type = methodString[1];
            String[] name_and_args = methodString[2].split("[(]");
            String name = name_and_args[0];
            String args = (name_and_args[1].length() > 1 ) ? name_and_args[1].split("[)]")[0] : "";

            Map<String, String> methodInfos = new HashMap<String, String>(){{
                put("access", access);
                put("return_type", getCPPEquivalence(return_type));
                put("name", name);
                put("arguments", getEquivalenceOfList(args));
            }};

            allMethodsInfos.add(methodInfos);
        }
    }


}
