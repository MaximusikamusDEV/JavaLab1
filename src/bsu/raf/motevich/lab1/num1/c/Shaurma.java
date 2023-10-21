package bsu.raf.motevich.lab1.num1.c;

public class Shaurma extends Food{

    String filling1;
    String filling2;

    public Shaurma(String filling1, String filling2)
    {
        super("Шаурма");
        this.filling1 = filling1;
        this.filling2 = filling2;
    }

    @Override
    public void consume() {
        System.out.println("Сьедена шаурма с " + filling1 + " и " + filling2);
    }

    @Override
    public void calculateCalories() {
        if(filling2 == null || filling1 == null)
        {
            System.out.println("Наша шаурма бескалорийная.");
            return;
        }
        System.out.println("Calories: " + (filling1.length() + filling2.length()));
    }

    @Override
    public int calculateCaloriesWithoutOut() {
        if(filling2 == null || filling1 == null)
            return 0;


        return filling1.length() + filling2.length();
    }
}
