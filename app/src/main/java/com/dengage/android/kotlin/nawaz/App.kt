package com.dengage.android.kotlin.nawaz

import android.R
import android.app.Application
import android.content.Context
import android.text.TextUtils
import com.dengage.android.kotlin.nawaz.utils.Constants
import com.dengage.sdk.*
import com.dengage.sdk.rfm.model.RFMGender
import com.dengage.sdk.rfm.model.RFMItem

/**
 * Created by Batuhan Coskun on 02 December 2020
 */
class App : Application() {

    lateinit var dengageManager: DengageManager
    lateinit var dengageEvent: DengageEvent

    override fun onCreate() {
        super.onCreate()

        // to handle application bring to foreground
        registerActivityLifecycleCallbacks(DengageLifecycleTracker())

        // should be initiated once in application runtime
        dengageManager = DengageManager
            .getInstance(applicationContext)
            .setLogStatus(true)
            .setFirebaseIntegrationKey(Constants.FIREBASE_APP_INTEGRATION_KEY)
            .setHuaweiIntegrationKey("bfdaf13d3cc85ca0771b459b653d42ebd4006b6cd5c715c11bfa6d912b8d6fd3")
            .init()

        // should be initiated once in application runtime
        dengageEvent = DengageEvent.getInstance(applicationContext)
/*dengageManager.sortRFMItems<RFMItem>(
    rfmGender = RFMGender.MALE,
    rfmItems = rfmItems
)

        val rfmItems = mutableListOf(
            RFMItem(
                id = "1",
                categoryId = "1",
                personalized = true,
                gender = RFMGender.MALE,
                sequence = 3
            ),
            RFMItem(
                id = "2",
                categoryId = "1",
                personalized = false,
                gender = RFMGender.FEMALE,
                sequence = 2
            ),
            RFMItem(
                id = "3",
                categoryId = "1",
                personalized = true,
                gender = RFMGender.FEMALE,
                sequence = 1
            ),
            RFMItem(
                id = "4",
                categoryId = "1",
                personalized = false,
                gender = RFMGender.MALE,
                sequence = 1
            )
        )
        val rfmItems = mutableListOf(
            RFMItem(
                id = "1",
                categoryId = "1",
                personalized = true,
                gender = RFMGender.MALE,
                sequence = 3
            ),
            RFMItem(
                id = "2",
                categoryId = "1",
                personalized = false,
                gender = RFMGender.FEMALE,
                sequence = 2
            ),
            RFMItem(
                id = "3",
                categoryId = "1",
                personalized = true,
                gender = RFMGender.FEMALE,
                sequence = 1
            ),
            RFMItem(
                id = "4",
                categoryId = "1",
                personalized = false,
                gender = RFMGender.MALE,
                sequence = 1
            )
        )*/
        //set dengage notification channel name
      // dengageManager.setChannelName("Test Channel");

        getSmallIconColorId(context = applicationContext)
    }


    protected fun getSmallIconColorId(context: Context): Int {
        val smallIcon: String = Utils.getMetaData(context, "den_push_small_icon_color")
        if (!TextUtils.isEmpty(smallIcon)) {
            val appIconColorId: Int = getColorResourceId(context, smallIcon)
//            NotificationReceiver.logger.Verbose("Application icon: " + smallIcon)
            return appIconColorId
        } else {
            return -1
        }
    }

    fun getColorResourceId(context: Context, resourceName: String?): Int {
        if (TextUtils.isEmpty(resourceName)) {
            return 0
        } else if (Utils.isInteger(resourceName)) {
            return 0
        } else {
            try {
                val resourceId: Int = context.getResources().getIdentifier(resourceName, "color", context.getPackageName())
                return resourceId
            } catch (var6: Exception) {
                try {
                    val defaultResourceId: Int =
                        R.color::class.java.getField(resourceName).getInt(null as Any?)
                    return defaultResourceId
                } catch (var5: Throwable) {
                    var6.printStackTrace()
                    return 0
                }
            }
        }
    }

}