package com.ticonsys.filteredfilepicker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.afollestad.materialdialogs.MaterialDialog
import com.ticonsys.filepicker.data.model.Filter
import com.ticonsys.filepicker.internal.FilterItemClickListener
import com.ticonsys.filepicker.ui.FilterDialog
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), FilterItemClickListener {

    companion object{
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnFilePicker.setOnClickListener {
            FilterDialog(this, this).show()
        }

    }

    override fun onFilterItemClick(
        dialog: MaterialDialog?,
        filter: Filter
    ) {
        Log.d(TAG, "File Choose: $filter")
        dialog?.dismiss()
    }


}
