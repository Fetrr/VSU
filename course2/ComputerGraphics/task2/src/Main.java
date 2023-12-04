import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        MainWindow mw = new MainWindow();
        mw.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        mw.setSize(800, 600);
        mw.setTitle("Bezier curve");
        mw.setVisible(true);
    }
    /*
    ToDo: трисовка через drawLine, сделать массив с точками (чтобы координаты X Y были вместе), добавить определение
     ломанных линий, чтобы увеличивать им детализацию, проверить инкапсуляцию.
     */
}