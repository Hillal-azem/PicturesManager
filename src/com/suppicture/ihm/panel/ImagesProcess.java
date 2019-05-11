package panel;

import java.util.ArrayList;
import java.util.List;
import com2.load.images.Icon;

public class ImagesProcess {

    private static List<Icon> selectedImages = new ArrayList<>();


    private static void addToList(Icon icon){
        selectedImages.add(icon);
    }

    private static void removeFromList(Icon icon){
        selectedImages.remove(icon);
    }

    public static boolean select(Icon icon){

        if (selectedImages.contains(icon)){
            removeFromList(icon);
            return true;
        }
        else{
            addToList(icon);
            return false;
        }
    }

    /**
     * Getter on the selectedImage list
     * @return List
     */
    public static List<Icon> getSelectedImages() {
        return selectedImages;
    }


    /**
     * Check if images are selected on the panel
     * @return boolean
     */
    public static boolean noImagesSelected(){
        return selectedImages.isEmpty();
    }
}
