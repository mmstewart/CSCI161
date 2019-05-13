package lab03;

/**
 *
 * @author Marcus
 * @version 9/16/16
 * * The Courses class
 * * * Adds a string method to the course constructor, so you can enter the courses.
 * * * * Methods allow the ability to add a String class name to an object reference/also can either get or set the name.
 * * * * * Used in NDSUBasketball Client.
 */
public class Courses {

    public String name;

    /**
     *
     * @param name
     */
    public Courses(String name) {
        this.name = name;
    }

    /**
     * 
     * @return 
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * 
     * @param name 
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return getName();
    }

    /**
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Courses)) {
            return false;
        } else {
            Courses c = (Courses) o;
            return name.equalsIgnoreCase(c.name);
        }
    }
}
