package com.gadik.myfavoritemovies.NetworkUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by gadik
 */

public class NetworkUtils {

    /**
     * This method returns the whole result from the HTTP response
     * @param url The Uniform Resource Locator from where to fetch the response
     * @return String - Our HTTP response
     * @throws IOException Related to connecting the network and using streams
     */
    public static String getResponseFromURL(URL url) throws IOException {

        // Creating the HttpURLConnection object
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        try {
            InputStream in = urlConnection.getInputStream();

            // Read the contents of the input stream by tokenize streams
            Scanner scan = new Scanner(in);
            // Read all contents by setting the delimiter to "\\A" - the beginning of the stream
            scan.useDelimiter("\\A");

            // The scanner allocate and deallocate the needed buffers
            // and handles character encoding (UTF-8 -> UTF-16)
            if(scan.hasNext()){
                return (scan.next());
            } else {
                return null;
            }

        } finally {
            urlConnection.disconnect();
        }
    }
}
