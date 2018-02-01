package uk.ac.aston.paskannm.pockettraveler.helper;

import java.io.File;
import java.util.ArrayList;
import java.util.Locale;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;
import android.widget.Toast;

/**
 * This class holds reusable functions across application
 */

public class Utils {

    private Context context;

    public Utils(Context context) {
        this.context = context;
    }

    // Reading file paths from directory
    public ArrayList<String> getFilePaths() {
        ArrayList<String> filePaths = new ArrayList<String>();

        File directory = new File(
                android.os.Environment.getExternalStorageDirectory() +
                        File.separator +
                        AppConstant.PHOTO_ALBUM
        );

        // Check for directory
        if (directory.isDirectory()) {

            // Getting list of file paths
            File[] listFiles = directory.listFiles();

            // Check for count
            if (listFiles.length > 0) {

                // Loop through all files
                for (int i = 0; i < listFiles.length; i++) {

                    // Get file path
                    String filePath = listFiles[i].getAbsolutePath();

                    // Check for supported file extension
                    if (IsSupportedFile(filePath)) {

                        // Add image path to array list
                        filePaths.add(filePath);
                    }
                }
            } else {
                // Image directory is empty
                Toast.makeText(
                        context,
                        AppConstant.PHOTO_ALBUM + " is empty.",
                        Toast.LENGTH_SHORT).show();
            }
        } else {
            AlertDialog.Builder alert = new AlertDialog.Builder(context);
            alert.setTitle("Error!");
            alert.setMessage(AppConstant.PHOTO_ALBUM +
                    " directory path is not valid! Set image directory name in AppConstant.java");
            alert.setPositiveButton("OK", null);
            alert.show();
        }
        return filePaths;
    }

    // Check supported file extensions
    private boolean IsSupportedFile(String filePath) {
        String ext = filePath.substring((filePath.lastIndexOf(".") + 1), filePath.length());

        //AppConstant.FILE_EXTN.contains(ext.toLowerCase(Locale.getDefault())) ? return true : return false;
        if (AppConstant.FILE_EXTN.contains(ext.toLowerCase(Locale.getDefault()))) {
            return true;
        } else {
            return false;
        }
    }

    // Get screen width
    public int getScreenWidth() {
        int columnWidth;
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();

        final Point point = new Point();

        try {
            display.getSize(point);
        } catch (java.lang.NoSuchMethodError ignore) {
            // Older device
            point.x = display.getWidth();
            point.y = display.getHeight();
        }

        columnWidth = point.x;
        return columnWidth;
    }
}