package com.okhttpclientdemo.activities;

import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.okhttpclientdemo.R;

import dmax.dialog.SpotsDialog;

public class BaseActivity extends AppCompatActivity {
    String TAG = BaseActivity.class.getSimpleName();

    public AdView adView;

    Dialog dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadAds();

        /*dialog = SpotsDialog.Builder()
                .setContext(this)
                .setMessage(R.string.custom_title)
                .setTheme(R.style.Custom)
                .build();*/
    }

    private void loadAds() {
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

            }
        });

    }

    public void showBanner() {
        //  MobileAds.getInitializationStatus().getAdapterStatusMap()

        AdRequest adRequest = new AdRequest.Builder().build();
//                adView.setAdUnitId("ca-app-pub-3940256099942544/6300978111");
        adView.loadAd(adRequest);
        adView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                Log.e("onAdLoaded", "onAdLoaded");
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                Log.e("onAdFailedToLoad", "onAdFailedToLoad " + errorCode);

            }

            @Override
            public void onAdOpened() {
                Log.e("onAdOpened", "onAdOpened");

            }

            @Override
            public void onAdClicked() {
                Log.e("onAdClicked", "onAdClicked");

            }

            @Override
            public void onAdLeftApplication() {
                Log.e("onAdLeftApplication", "onAdLeftApplication");

            }

            @Override
            public void onAdClosed() {
                Log.e("onAdClosed", "onAdClosed");

            }
        });
    }


    public void showInterstitial() {
        InterstitialAd mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_adunitid));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                Log.e("onAdLoaded", "onAdLoaded");
                mInterstitialAd.show();
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                Log.e("onAdFailedToLoad", "onAdFailedToLoad " + errorCode);

            }

            @Override
            public void onAdOpened() {
                Log.e("onAdOpened", "onAdOpened");

            }

            @Override
            public void onAdClicked() {
                Log.e("onAdClicked", "onAdClicked");

            }

            @Override
            public void onAdLeftApplication() {
                Log.e("onAdLeftApplication", "onAdLeftApplication");

            }

            @Override
            public void onAdClosed() {
                Log.e("onAdClosed", "onAdClosed");

            }
        });
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }
    }


    public void showNativeAds() {
        AdLoader adLoader = new AdLoader.Builder(this, "ca-app-pub-3940256099942544/2247696110")
                .forUnifiedNativeAd(new UnifiedNativeAd.OnUnifiedNativeAdLoadedListener() {
                    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
                    @Override
                    public void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
                        Log.e("onUnifiedNativeAdLoaded", unifiedNativeAd + "");
                    //d    adLoader.show();
                        /*if (isDestroyed()) {
                            unifiedNativeAd.destroy();
                            return;
                        }*/
                        // Show the ad.
                    }
                })
                .withAdListener(new AdListener() {
                    @Override
                    public void onAdFailedToLoad(int errorCode) {
                        Log.e("onAdFailedToLoad", "onAdFailedToLoad " + errorCode);

                        // Handle the failure by logging, altering the UI, and so on.
                    }
                })
                .withNativeAdOptions(new NativeAdOptions.Builder()
                        // Methods in the NativeAdOptions.Builder class can be
                        // used here to specify individual options settings.
                        .build())
                .build();
        adLoader.loadAds(new AdRequest.Builder().build(), 3);

    }

}
