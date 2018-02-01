package uk.ac.aston.paskannm.pockettraveler.helper;

import android.os.Environment;
import android.provider.ContactsContract;

import java.util.Arrays;
import java.util.List;

/**
 * This class holds static constants used across application
 */

public class AppConstant {

    // Number of Columns of Grid View
    public static final int NUM_OF_COLUMNS = 3;

    // Grid View image padding in dp
    public static final int GRID_PADDING = 8;

    // SD card image directory
    public static final String PHOTO_ALBUM = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath();

    // Supported file formats
    public static final List<String> FILE_EXTN = Arrays.asList("jpg", "jpeg", "png");
}
