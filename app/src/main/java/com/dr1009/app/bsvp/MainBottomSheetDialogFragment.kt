package com.dr1009.app.bsvp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dr1009.app.bsvp.databinding.FragmentMainBottomSheetDialogBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class MainBottomSheetDialogFragment : BottomSheetDialogFragment() {

    companion object {
        const val TAG = "MainBottomSheetDialogFragment"

        fun newInstance() = MainBottomSheetDialogFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_main_bottom_sheet_dialog, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentMainBottomSheetDialogBinding.bind(view)
    }
}