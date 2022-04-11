package com.pankajkcodes.unityadsinkotlin

import android.app.Activity
import android.widget.LinearLayout
import android.widget.Toast
import com.unity3d.ads.IUnityAdsInitializationListener
import com.unity3d.ads.IUnityAdsShowListener
import com.unity3d.ads.UnityAds
import com.unity3d.ads.UnityAdsShowOptions
import com.unity3d.services.banners.BannerErrorInfo
import com.unity3d.services.banners.BannerView
import com.unity3d.services.banners.UnityBannerSize

class AdsManger(private val activity: Activity) :
    IUnityAdsInitializationListener {


    companion object {

        private const val UNITY_GAME_ID = "4702293"
        private const val UNITY_BANNER_ID = "Banner_Android"
        private const val UNITY_INTERSTITIAL_ID = "Interstitial_Android"
        private const val UNITY_REWARDED_ID = "Rewarded_Android"
        private const val isTestMode = true
    }

    private fun showToast(msg: String) {
        Toast.makeText(activity.applicationContext, msg, Toast.LENGTH_LONG).show()
    }

    fun initialize() {
        UnityAds.initialize(activity.applicationContext, UNITY_GAME_ID, isTestMode, this)

        showToast("Initialize")
    }

    fun showBanner(bannerLayout: LinearLayout) {
        val bannerView = BannerView(
            activity,
            UNITY_BANNER_ID,
            UnityBannerSize(320, 50)
        )
        bannerView.listener = UnityAdsBannerListener()
        bannerView.load()
        bannerLayout.addView(bannerView)
        showToast("Request Banner")

    }

    fun showInterstitial() {
        UnityAds.show(
            activity,
            UNITY_INTERSTITIAL_ID,
            UnityAdsShowOptions(),
            UnityAdsShowListener()
        )
        showToast("Request Interstitial")
    }

    fun showRewarded() {
        UnityAds.show(
            activity,
            UNITY_REWARDED_ID,
            UnityAdsShowOptions(),
            UnityAdsShowListener()
        )
        showToast("Request Rewarded")
    }


    class UnityAdsBannerListener : BannerView.IListener {
        override fun onBannerLoaded(p0: BannerView?) {

        }

        override fun onBannerClick(p0: BannerView?) {

        }

        override fun onBannerFailedToLoad(p0: BannerView?, p1: BannerErrorInfo?) {

        }

        override fun onBannerLeftApplication(p0: BannerView?) {

        }

    }


    class UnityAdsShowListener : IUnityAdsShowListener {
        override fun onUnityAdsShowFailure(
            p0: String?,
            p1: UnityAds.UnityAdsShowError?,
            p2: String?
        ) {

        }

        override fun onUnityAdsShowStart(p0: String?) {

        }

        override fun onUnityAdsShowClick(p0: String?) {

        }

        override fun onUnityAdsShowComplete(
            p0: String?,
            p1: UnityAds.UnityAdsShowCompletionState?
        ) {

        }

    }

    override fun onInitializationComplete() {
       showToast("initialize complete")
    }

    override fun onInitializationFailed(p0: UnityAds.UnityAdsInitializationError?, p1: String?) {
        showToast("initialize failed... re init......")
        initialize()
    }
}
