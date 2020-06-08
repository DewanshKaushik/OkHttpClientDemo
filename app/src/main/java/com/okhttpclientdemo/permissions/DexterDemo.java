package com.okhttpclientdemo.permissions;

import android.Manifest;
import android.content.Context;
import android.widget.ImageView;

import com.google.android.material.snackbar.Snackbar;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.karumi.dexter.listener.single.DialogOnDeniedPermissionListener;
import com.karumi.dexter.listener.single.PermissionListener;
import com.karumi.dexter.listener.single.SnackbarOnDeniedPermissionListener;
import com.okhttpclientdemo.R;

import java.util.List;

public class DexterDemo {



    public void takePermissions(Context context) {
        Dexter.withContext(context)
                .withPermission(Manifest.permission.CAMERA)
                .withListener(new PermissionListener() {
                    @Override public void onPermissionGranted(PermissionGrantedResponse response) {/* ... */}
                    @Override public void onPermissionDenied(PermissionDeniedResponse response) {/* ... */}
                    @Override public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {

                        /* ... */}
                }).check();

        PermissionListener dialogPermissionListener =
                DialogOnDeniedPermissionListener.Builder
                        .withContext(context)
                        .withTitle("Camera permission")
                        .withMessage("Camera permission is needed to take pictures of your cat")
                        .withButtonText(android.R.string.ok)
                        .withIcon(R.mipmap.ic_launcher)
                        .build();

        PermissionListener snackbarPermissionListener =
                SnackbarOnDeniedPermissionListener.Builder
                        .with(new ImageView(null), "Camera access is needed to take pictures of your dog")
                        .withOpenSettingsButton("Settings")
                        .withCallback(new Snackbar.Callback() {
                            @Override
                            public void onShown(Snackbar snackbar) {
                                // Event handler for when the given Snackbar is visible
                            }
                            @Override
                            public void onDismissed(Snackbar snackbar, int event) {
                                // Event handler for when the given Snackbar has been dismissed
                            }
                        }).build();



    }

    public void takeMultiplePermissions(Context context){
        Dexter.withContext(context)
                .withPermissions(
                        Manifest.permission.CAMERA,
                        Manifest.permission.READ_CONTACTS,
                        Manifest.permission.RECORD_AUDIO
                ).withListener(new MultiplePermissionsListener() {
            @Override public void onPermissionsChecked(MultiplePermissionsReport report) {/* ... */}
            @Override public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {/* ... */}
        }).check();

    }

}
