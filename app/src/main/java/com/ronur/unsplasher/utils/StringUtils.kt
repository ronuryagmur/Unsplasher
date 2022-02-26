package com.ronur.unsplasher.utils

import android.app.Application
import com.ronur.unsplasher.R

class StringUtils(private val applicationCtx: Application) {
    fun noNetworkErrorMessage() = applicationCtx.getString(R.string.no_network_connection)
    fun somethingWentWrong() = applicationCtx.getString(R.string.something_went_wrong)
}