package com.ticonsys.filepicker.data.groupie

import com.afollestad.materialdialogs.MaterialDialog
import com.ticonsys.filepicker.R
import com.ticonsys.filepicker.data.model.Filter
import com.ticonsys.filepicker.databinding.SimpleFilterItemBinding
import com.ticonsys.filepicker.internal.FilterItemClickListener
import com.xwray.groupie.databinding.BindableItem


class FilterItem(
    private val listener: FilterItemClickListener,
    private val dialog: MaterialDialog,
    private val filter: Filter
): BindableItem<SimpleFilterItemBinding>() {

    override fun getLayout() = R.layout.simple_filter_item

    override fun bind(viewBinding: SimpleFilterItemBinding, position: Int) {
        viewBinding.filter = filter
        viewBinding.listener = listener
        viewBinding.dialog = dialog
        viewBinding.ivPicker.setImageResource(filter.icon)
    }
}