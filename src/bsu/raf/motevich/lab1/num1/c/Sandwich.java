package bsu.raf.motevich.lab1.num1.c;

public class Sandwich extends Food {

    private String filling1;
    private String filling2;

    public Sandwich(String filling1, String filling2) {
        super("Сэндвич");
        this.filling1 = filling1;
        this.filling2 = filling2;
    }

    @Override
    public void calculateCalories() {
        if(filling2 == null || filling1 == null)
        {
            System.out.println("Наши булки бескалорийные.");
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

    @Override
    public boolean equals(Object arg) {
        if(!(arg instanceof Sandwich)) return false;
        if(filling1 == null || filling2 == null || ((Sandwich) arg).filling1 == null || ((Sandwich) arg).filling2 == null) return false;
              return (filling1.equals(((Sandwich) arg).filling1) || filling2.equals(((Sandwich) arg).filling2));
    }

    @Override
    public void consume() {
        if(filling2 == null || filling1 == null)
        {
            System.out.println("Съедена булка от сендвича.");
            return;
        }
        System.out.println("Съеден сендвич с " + filling1 + " и " + filling2);
    }
}
