package uk.ac.aston.paskannm.pockettraveler.adapter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import android.widget.BaseAdapter;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;

import uk.ac.aston.paskannm.pockettraveler.FullScreenViewActivity;
import uk.ac.aston.paskannm.pockettraveler.GridViewActivity;

/**
 * Grants ability to create reusable view for the grid view blocks
 */

public class GridViewImageAdapter extends BaseAdapter {

    private Activity activity;
    private ArrayList<String> filePaths = new ArrayList<String>();
    private int imageWidth;

    public GridViewImageAdapter(Activity activity, ArrayList<String> filePaths, int imageWidth) {
        this.activity = activity;
        this.filePaths = filePaths;
        this.imageWidth = imageWidth;
    }

    @Override
    public int getCount() {
        return this.filePaths.size();
    }

    @Override
    public Object getItem(int position) {
        return this.filePaths.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        if (convertView == null) {
            imageView = new ImageView(activity);
        } else {
            imageView = (ImageView) convertView;
        }

        // Get screen dimensions
        Bitmap image = decodeFile(filePaths.get(position), imageWidth, imageWidth);

        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(imageWidth, imageWidth));
        imageView.setImageBitmap(image);

        // Image view click listener
        imageView.setOnClickListener(new OnImageClickListener(position));

        return imageView;
    }

    class OnImageClickListener implements OnClickListener {

        int position;

        public OnImageClickListener(int position) {
            this.position = position;
        }

        @Override
        public void onClick(View view) {
            // On selecting grid view image, launch full screen activity
            Intent i = new Intent(activity, FullScreenViewActivity.class);
            i.putExtra("position", position);
            activity.startActivity(i);
        }
    }

    public static Bitmap decodeFile(String filePath, int WIDTH, int HEIGHT) {
        try {
            File f = new File(filePath);
            BitmapFactory.Options o = new BitmapFactory.Options();
            o.inJustDecodeBounds =true;
            BitmapFactory.decodeStream(new FileInputStream(f), null, o);
            final int REQUIRED_WIDTH = WIDTH;
            final int REQUIRED_HEIGHT = HEIGHT;
            int scale = 1;

            while (o.outWidth / scale / 2 >= REQUIRED_WIDTH && o.outHeight /scale / 2 >= REQUIRED_HEIGHT)
                scale *= 2;

            BitmapFactory.Options o2 = new BitmapFactory.Options();
            o2.inSampleSize = scale;

            return BitmapFactory.decodeStream(new FileInputStream(f), null, o2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
