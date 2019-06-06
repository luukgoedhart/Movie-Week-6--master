package com.example.movieweek6;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.InputStream;

public class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
    private ImageView bmImage;

    public DownloadImageTask(ImageView bmImage) {
        this.bmImage = bmImage;
    }

    public Bitmap doInBackground(String... urls) {
        String imageBaseUrl = "https://image.tmdb.org/t/p/original/";
        String urldisplay = imageBaseUrl + urls[0];
        System.out.println("kijk: " + urldisplay);
        Bitmap mIcon11 = null;
        try {
            InputStream in = new java.net.URL(urldisplay).openStream();
            mIcon11 = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
        return mIcon11;
    }

    public void onPostExecute(Bitmap result) {
        bmImage.setImageBitmap(result);
    }
}