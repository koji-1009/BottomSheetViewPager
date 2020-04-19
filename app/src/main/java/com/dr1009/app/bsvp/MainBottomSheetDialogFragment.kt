package com.dr1009.app.bsvp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.dr1009.app.bsvp.databinding.FragmentMainBottomSheetDialogBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class MainBottomSheetDialogFragment : BottomSheetDialogFragment() {

    companion object {
        const val TAG = "MainBottomSheetDialogFragment"

        fun newInstance() = MainBottomSheetDialogFragment()
    }

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_main_bottom_sheet_dialog, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentMainBottomSheetDialogBinding.bind(view)

        val size = viewModel.currentListSize()
        val adapter = ScreenSlidePagerAdapter(this, size)
        binding.viewPager.adapter = adapter
    }

    private inner class ScreenSlidePagerAdapter(
        fragment: Fragment,
        private val size: Int
    ) : FragmentStateAdapter(fragment) {
        override fun getItemCount(): Int = size

        override fun createFragment(position: Int): Fragment = ScreenSlidePageFragment.newInstance(position)
    }
}