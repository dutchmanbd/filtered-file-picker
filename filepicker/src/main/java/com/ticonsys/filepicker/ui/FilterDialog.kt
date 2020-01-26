package com.ticonsys.filepicker.ui

import android.app.Activity
import android.view.Gravity
import android.view.WindowManager
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.customview.customView
import com.afollestad.materialdialogs.customview.getCustomView
import com.ticonsys.filepicker.R
import com.ticonsys.filepicker.data.groupie.FilterItem
import com.ticonsys.filepicker.data.model.Filter
import com.ticonsys.filepicker.data.model.FilterType
import com.ticonsys.filepicker.internal.FilterItemClickListener
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import kotlinx.android.synthetic.main.dialog_filter.view.*

class FilterDialog(
    private val listener: FilterItemClickListener,
    private val activity: Activity
) {

    private val dialog by lazy {
        MaterialDialog(activity)
            .cornerRadius(16f)
            .customView(R.layout.dialog_filter)
    }


    fun show(){
        val window = dialog.window
        val wlp = window?.attributes
        wlp?.gravity = Gravity.BOTTOM
        wlp?.y = 100
        wlp?.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND
        window?.attributes = wlp

        dialog.show()

        val view = dialog.getCustomView()
        val pickerAdapter = GroupAdapter<GroupieViewHolder>()
        pickerAdapter.addAll(
            listOf(
                Filter(
                    FilterType.ITEM_GALLERY,
                    R.drawable.ic_gallery,
                    "Gallery"
                ),
                Filter(
                    FilterType.ITEM_CAMERA,
                    R.drawable.ic_camera1,
                    "Camera"
                ),
                Filter(
                    FilterType.ITEM_FILES,
                    R.drawable.ic_documents,
                    "Documents"
                ),
                Filter(
                    FilterType.ITEM_VIDEO_GALLERY,
                    R.drawable.ic_video,
                    "Video"
                ),
                Filter(
                    FilterType.ITEM_AUDIO,
                    R.drawable.ic_audio,
                    "Audio"
                )
            ).toFilterItems()
        )
        view.rvFileFilter?.apply {
            adapter = pickerAdapter
        }

    }

    private fun List<Filter>.toFilterItems() = map {
        FilterItem(listener, dialog, it)
    }


}