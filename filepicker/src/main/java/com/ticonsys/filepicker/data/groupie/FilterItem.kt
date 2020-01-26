package com.ticonsys.filepicker.data.groupie

import com.afollestad.materialdialogs.MaterialDialog
import com.ticonsys.filepicker.R
import com.ticonsys.filepicker.data.model.Filter
import com.ticonsys.filepicker.databinding.SimpleFilterItemBinding
import com.ticonsys.filepicker.internal.FilterItemClickListener
import com.xwray.groupie.databinding.BindableItem


class FilterItem(
    val filter: Filter
): BindableItem<SimpleFilterItemBinding>() {

    override fun getLayout() = R.layout.simple_filter_item

    override fun bind(viewBinding: SimpleFilterItemBinding, position: Int) {
        viewBinding.filter = filter
        viewBinding.ivPicker.setImageResource(filter.icon)
    }
}