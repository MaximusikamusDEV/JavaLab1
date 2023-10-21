package bsu.raf.motevich.lab1.num1.c;

public abstract class Food implements Nutritious, Consume{

    private String name = null;

    public Food(String name)
    {
        this.name = name;
    }

    public String GetName()
    {
        return name;
    }
    public boolean equals(Object arg)
    {
        if(!(arg instanceof Food)) return false;
        if(name == null || ((Food) arg).name == null) return false;
        return name.equals(((Food) arg).name);
    }
}
