package com.ticonsys.filepicker.internal

import com.afollestad.materialdialogs.MaterialDialog
import com.ticonsys.filepicker.data.model.Filter


interface FilterItemClickListener {
    fun onFilterItemClick(dialog: MaterialDialog?, filter: Filter)
}