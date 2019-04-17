import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionDemo {

    public static void main(String [] args){

        //Create the Student object
        Student student =  new Student();

        //Creating Class Object from the Student
        Class studentClass = student.getClass();
        System.out.println("Get Student Class : "+studentClass);

        //View all Constructors of the class : Reflection
        Constructor [] constructors = studentClass.getConstructors();

        //Print each constructor
        System.out.println("Printing Constructors for Student Class \n");
        for(Constructor constructor:constructors){
            //Shows a list of constructors
            System.out.println(constructor);
        }


        //View All methods : reflection
        System.out.println("Printing Methods for Student Class\n");
        Method [] methods = studentClass.getMethods();

        //print each method in student class
        for (Method method:methods){
            //Shows A list of of methods and return type
            System.out.println(method);
        }

        //View public fields via reflection
        Field [] fields = studentClass.getFields();

        //Print each Field
        System.out.println("Printing Fields \n");
        for (Field field:fields){
            System.out.println(field);
        }

        try {
            //Get Declared Method
            Method getAgeMethod = studentClass.getDeclaredMethod("getComputedAge",null);
            getAgeMethod.setAccessible(true);


            try {
                // Invoke declared method
                System.out.println("Age is: "+getAgeMethod.invoke(student,null));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        try {
            Field age = studentClass.getDeclaredField("age");
            age.setAccessible(true);
            try {
                age.set(student,20);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            try {
                System.out.println("Original Age is \n "+ age.get(student));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
