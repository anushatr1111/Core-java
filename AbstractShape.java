public abstract class AbstractShape {
    abstract void calculateArea();
}
class Circle extends AbstractShape {
    private double radius;
    
    public Circle(double radius) {
        this.radius = radius;
    }
    
    @Override
    void calculateArea() {
        System.out.println("Area of Circle: " + (Math.PI * radius * radius));
    }
}
class Rectangle extends AbstractShape {
    private double length;
    private double width;
    
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
    
    @Override
    void calculateArea() {
        System.out.println("Area of Rectangle: " + (length * width));
    }
}
class Square extends AbstractShape {
    private double side;
    
    public Square(double side) {
        this.side = side;
    }
    
    @Override
    void calculateArea() {
        System.out.println("Area of Square: " + (side * side));
    }
    public static void main(String[] args) {
        AbstractShape s1 = new Circle(5);
        AbstractShape s2 = new Rectangle(4, 6);
        AbstractShape s3 = new Square(3);
        
        s1.calculateArea();
        s2.calculateArea();
        s3.calculateArea();
    }
}
