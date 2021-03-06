package com.dengage.android.kotlin.nawaz.ui.fragment

import android.app.DatePickerDialog
import com.dengage.android.kotlin.nawaz.R
import com.dengage.android.kotlin.nawaz.databinding.FragmentTagsBinding
import com.dengage.android.kotlin.nawaz.extensions.getDengageManager
import com.dengage.android.kotlin.nawaz.ui.base.BaseDataBindingFragment
import com.dengage.sdk.Constants
import com.dengage.sdk.models.TagItem
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Batuhan Coskun on 24 March 2021
 */
class TagsFragment : BaseDataBindingFragment<FragmentTagsBinding>() {

    private val simpleDateFormat =
        SimpleDateFormat(Constants.DATE_FORMAT, Locale.getDefault())
    private var selectedChangeTime: Date? = null
    private var selectedRemoveTime: Date? = null

    override fun getLayoutRes(): Int {
        return R.layout.fragment_tags
    }

    override fun init() {
        sendPageView("tags")

        binding.etChangeTime.setOnClickListener {
            DatePickerDialog(
                requireContext(),
                { _, year, month, dayOfMonth ->
                    val calendar = Calendar.getInstance()
                    calendar.set(Calendar.YEAR, year)
                    calendar.set(Calendar.MONTH, month)
                    calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                    selectedChangeTime = calendar.time
                    binding.etChangeTime.setText(simpleDateFormat.format(calendar.time))
                }, 2021, 0, 1
            ).show()
        }

        binding.etRemoveTime.setOnClickListener {
            DatePickerDialog(
                requireContext(),
                { _, year, month, dayOfMonth ->
                    val calendar = Calendar.getInstance()
                    calendar.set(Calendar.YEAR, year)
                    calendar.set(Calendar.MONTH, month)
                    calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                    selectedRemoveTime = calendar.time
                    binding.etRemoveTime.setText(simpleDateFormat.format(calendar.time))
                }, 2021, 0, 1
            ).show()
        }

        binding.btnSend.setOnClickListener {
            val tag = binding.etTag.text.toString().trim()
            val value = binding.etValue.text.toString().trim()
            val changeValue = binding.etChangeValue.text.toString().trim()

            val tags = mutableListOf<TagItem>()
            val tagItem = TagItem(
                tag,
                value,
                selectedChangeTime,
                changeValue,
                selectedRemoveTime
            )

            // you can init TagItem with below parameters
            /*val tagItem = TagItem(
                tag,
                value
            )*/

            tags.add(tagItem)
            activity?.getDengageManager()?.setTags(tags)
        }
    }
}