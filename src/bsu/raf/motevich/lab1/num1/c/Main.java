package bsu.raf.motevich.lab1.num1.c;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Main {

    public static int EqInBreakfast(String filling, Food[] breakfast)
    {
        Food ex = new Sandwich(filling, filling);
        int i = 0;

        for(Food fd: breakfast) {
            if(fd == null)
                break;

          //  fd.consume();

            if(fd.equals(ex))
                i++;
        }

        return i;
    }

    public static void main(String[] args) {

        Food[] breakfast = new Food[20];
        int i = 0;
        boolean calories = false;
        boolean sort = false;

        for(String arg: args)
        {
            String[] parts = arg.split("/");

            if(arg.equals("-calories")) {
                calories = true;
                continue;
            }

            if(arg.equals("-sort")) {
                sort = true;
                continue;
            }

           try {
             Class myClass = Class.forName("bsu.raf.motevich.lab1.num1.c." + parts[0]);
              if(parts.length == 1)
               {
                   try {
                       Constructor constr = myClass.getConstructor(String.class, String.class);
                       breakfast[i] = (Food) constr.newInstance(null, null);
                   } catch (NoSuchMethodException e) {
                       System.out.println("Maybe you named filling incorrect. Try again.\n");
                   } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
                       throw new RuntimeException(e);
                   }
               }
               else
               if(parts.length == 3)
               {
                   try {
                       Constructor constr = myClass.getConstructor(String.class, String.class);

                       breakfast[i] = (Food) constr.newInstance(parts[1], parts[2]);
                   } catch (NoSuchMethodException | IllegalAccessException | InstantiationException |
                            InvocationTargetException e) {
                       throw new RuntimeException(e);
                   }
               }
            } catch (ClassNotFoundException e) {
                System.out.println("We can't find this food in our menu.\n");
                i--;
            }



            i++;
        }

        int sumcal = 0;

        if(sort)
            Arrays.sort(breakfast, (o1, o2) -> {
                if(o1 == null) return 1;
                if(o2 == null) return -1;
                return o1.GetName().compareTo(o2.GetName());
            });

        for(Food fd: breakfast)
            if(fd == null) break;
        else {

            if(calories)
              sumcal += fd.calculateCaloriesWithoutOut();
                fd.consume();
              //  fd.calculateCalories();
                System.out.println();
            }

        if(calories)
            System.out.println("Количество каллорий: " + sumcal);

        System.out.println("Количество Майонеза: " + EqInBreakfast("Майонез", breakfast));

    }
}