/*
 * Copyright Cypress Semiconductor Corporation, 2014 All rights reserved.
 * 
 * This software, associated documentation and materials ("Software") is
 * owned by Cypress Semiconductor Corporation ("Cypress") and is
 * protected by and subject to worldwide patent protection (UnitedStates and foreign), United States copyright laws and international
 * treaty provisions. Therefore, unless otherwise specified in a separate license agreement between you and Cypress, this Software
 * must be treated like any other copyrighted material. Reproduction,
 * modification, translation, compilation, or representation of this
 * Software in any other form (e.g., paper, magnetic, optical, silicon)
 * is prohibited without Cypress's express written permission.
 * 
 * Disclaimer: THIS SOFTWARE IS PROVIDED AS-IS, WITH NO WARRANTY OF ANY
 * KIND, EXPRESS OR IMPLIED, INCLUDING, BUT NOT LIMITED TO,
 * NONINFRINGEMENT, IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS
 * FOR A PARTICULAR PURPOSE. Cypress reserves the right to make changes
 * to the Software without notice. Cypress does not assume any liability
 * arising out of the application or use of Software or any product or
 * circuit described in the Software. Cypress does not authorize its
 * products for use as critical components in any products where a
 * malfunction or failure may reasonably be expected to result in
 * significant injury or death ("High Risk Product"). By including
 * Cypress's product in a High Risk Product, the manufacturer of such
 * system or application assumes all risk of such use and in doing so
 * indemnifies Cypress against all liability.
 * 
 * Use of this Software may be limited by and subject to the applicable
 * Cypress software license agreement.
 * 
 * 
 */

package com.evangeline.exviewpager.utils;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.view.View;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Class for commonly used methods in the project
 */
public class Utils {
	public static String  DATA_FORMENT = "yyyy-MM-dd HH:mm:ss";
	public static String  DATA_FORMENT_NO = "yyyyMMddHHmmss";

    // Shared preference constant
    static String SHARED_PREF_NAME = "Senthink Pay";
    
    
    public static int getCharNum(String string, char c) {
		int count = 0;
		char[] chars = string.toCharArray();
		for(int i = 0;i<chars.length;i++) {
			if(c == chars[i]) {
				count++;
			}
		}
		return count;
	}
	
	public static int getScreenWidth(Context context) {
		return context.getResources().getDisplayMetrics().widthPixels;
	}
	
	public static int getScreenHeight(Context context) {
		return context.getResources().getDisplayMetrics().heightPixels;
	}

	public static float getScreenDensity(Context context) {
		return context.getResources().getDisplayMetrics().density;
	}
	
   
    /**
     * Converting the Byte to binary
     *
     * @param bytes
     * @return {@link String}
     */
    public static String BytetoBinary(byte[] bytes) {
        StringBuilder sb = new StringBuilder(bytes.length * Byte.SIZE);
        for (int i = 0; i < Byte.SIZE * bytes.length; i++)
            sb.append((bytes[i / Byte.SIZE] << i % Byte.SIZE & 0x80) == 0 ? '0'
                    : '1');
        return sb.toString();
    }   

    /**
     * Get the data from milliseconds
     *
     * @return {@link String}
     */
    public static String GetDateFromMilliseconds() {
        DateFormat formatter = new SimpleDateFormat("dd MMM yyyy");
        Calendar calendar = Calendar.getInstance();
        return formatter.format(calendar.getTime());

    }

    /**
     * Get the date
     *
     * @return {@link String}
     */
    public static String GetDate() {
        DateFormat formatter = new SimpleDateFormat(DATA_FORMENT);
        Calendar calendar = Calendar.getInstance();
        return formatter.format(calendar.getTime());
    }    

    public static String GetDateNo() {
        DateFormat formatter = new SimpleDateFormat(DATA_FORMENT_NO);
        Calendar calendar = Calendar.getInstance();
        return formatter.format(calendar.getTime());

    } 
    
    /**
     * Get the seven days before date
     *
     * @return {@link String}
     */

    public static String GetDateSevenDaysBack() {
        DateFormat formatter = new SimpleDateFormat("dd_MMM_yyyy");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -7);
        return formatter.format(calendar.getTime());

    }

    /**
     * Get the time from milliseconds
     *
     * @return {@link String}
     */
    public static String GetTimeFromMilliseconds() {
        DateFormat formatter = new SimpleDateFormat("HH:mm ss SSS");
        Calendar calendar = Calendar.getInstance();
        return formatter.format(calendar.getTime());

    }

    /**
     * Get time and date
     *
     * @return {@link String}
     */

    public static String GetTimeandDate() {
        DateFormat formatter = new SimpleDateFormat("dd MMM yyyy HH:mm ss");
        Calendar calendar = Calendar.getInstance();
        return formatter.format(calendar.getTime());

    }

    /**
     * Setting the shared preference with values provided as parameters
     *
     * @param context
     * @param key
     * @param value
     */
    public static final void setStringSharedPreference(Context context,
                                                       String key, String value) {
        SharedPreferences goaPref = context.getSharedPreferences(
                SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = goaPref.edit();
        editor.putString(key, value);
        editor.commit();
    }

    /**
     * Setting the shared preference with values provided as parameters
     *
     * @param context
     * @param key
     * @param value
     */
	public static final void setIntSharedPreference(Context context,
			String key, int value) {
		SharedPreferences goaPref = context.getSharedPreferences(
				SHARED_PREF_NAME, Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = goaPref.edit();
		editor.putInt(key, value);
		editor.commit();
	}

    /**
     * Returning the stored values in the shared preference with values provided
     * as parameters
     *
     * @param context
     * @param key
     * @return
     */
    public static final String getStringSharedPreference(Context context,
                                                         String key) {
        if (context != null) {

            SharedPreferences Pref = context.getSharedPreferences(
                    SHARED_PREF_NAME, Context.MODE_PRIVATE);
            String value = Pref.getString(key, "");
            return value;

        } else {
            return "";
        }
    }
    
    /**
     * Returning the stored values in the shared preference with values provided
     * as parameters
     *
     * @param context
     * @param key
     * @return
     */
	public static final int getIntSharedPreference(Context context, String key) {
		if (context != null) {

			SharedPreferences Pref = context.getSharedPreferences(
					SHARED_PREF_NAME, Context.MODE_PRIVATE);
			int value = Pref.getInt(key, 0);
			return value;

		} else {
			return 0;
		}
	}

    /**
     * Take the screen shot of the device
     *
     * @param view
     */
    public static void screenShotMethod(View view) {
        Bitmap bitmap;
        if (view != null) {
            View v1 = view;
            v1.setDrawingCacheEnabled(true);
            v1.buildDrawingCache(true);
            bitmap = Bitmap.createBitmap(v1.getDrawingCache());
            v1.setDrawingCacheEnabled(false);

            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
            File f = new File(Environment.getExternalStorageDirectory()
                    + File.separator + "temporary_file.jpg");
            try {
                f.createNewFile();
                FileOutputStream fo = new FileOutputStream(f);
                fo.write(bytes.toByteArray());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * Setting up the action bar with values provided as parameters
     *
     * @param context
     * @param title
     */
    public static void setUpActionBar(Activity context, String title) {
        ActionBar actionBar = context.getActionBar();
        actionBar.setIcon(new ColorDrawable(context.getResources().getColor(
                android.R.color.transparent)));
        actionBar.setTitle(title);
    }

    /**
     * Check whether Internet connection is enabled on the device
     *
     * @param context
     * @return
     */
    public static final boolean checkNetwork(Context context) {
        if (context != null) {
            boolean result = true;
            ConnectivityManager connectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager
                    .getActiveNetworkInfo();
            if (networkInfo == null || !networkInfo.isConnectedOrConnecting()) {
                result = false;
            }
            return result;
        } else {
            return false;
        }
    }
}
