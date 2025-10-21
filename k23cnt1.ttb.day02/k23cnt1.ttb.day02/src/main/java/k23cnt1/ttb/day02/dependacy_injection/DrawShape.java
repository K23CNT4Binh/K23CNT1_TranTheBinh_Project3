package k23cnt1.ttb.day02.dependacy_injection;

public class DrawShape {
    private Shape shape;

    // Constructor Injection
    public DrawShape(Shape shape) {
        this.shape = shape;
    }

    public void Draw() {
        shape.draw();
    }

    public static void main(String[] args) {
        Shape circle = new CircleShape();
        DrawShape draw1 = new DrawShape(circle);
        draw1.Draw();

        Shape rectangle = new RectangleShape();
        DrawShape draw2 = new DrawShape(rectangle);
        draw2.Draw();
    }
}
