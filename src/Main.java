import com.images.ImagesProcess;
import frame.MainFrame;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        MainFrame windows = new MainFrame();

        ImagesProcess images = new ImagesProcess("Images/myImages");
    }
}
