import view.IFrameView;
import view.mainFrameView;


public class Main {

    public static void main(String[] args) {




        IFrameView frameView = new mainFrameView(50, 10, "Bobby");

        String string = frameView.createBorderString();
        System.out.println(string);
    }
}