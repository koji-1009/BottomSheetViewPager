package com.dr1009.app.bsvp

import android.os.Bundle
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.dr1009.app.bsvp.databinding.FragmentCardAnimalBinding

class ScreenSlidePageFragment : Fragment(R.layout.fragment_card_animal) {

    companion object {
        private const val ARGS_POSITION = "args_position"

        fun newInstance(position: Int) = ScreenSlidePageFragment().apply {
            arguments = Bundle(1).apply {
                putInt(ARGS_POSITION, position)
            }
        }
    }

    private val position by lazy { requireArguments().getInt(ARGS_POSITION) }
    private val viewModel: MainViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentCardAnimalBinding.bind(view)

        val animal = viewModel.findAnimal(position)
        binding.textInputBirthday.setText(animal.birthday.formatLongStyle())
        binding.textInputName.setText(animal.name)
        binding.textInputName.addTextChangedListener {
            viewModel.updateAnimal(
                position,
                it?.toString() ?: "",
                binding?.textInputMemo?.text?.toString() ?: ""
            )
        }
        binding.textInputMemo.setText(animal.memo)
        binding.textInputMemo.addTextChangedListener {
            viewModel.updateAnimal(
                position,
                binding?.textInputName?.text?.toString() ?: "",
                it?.toString() ?: ""
            )
        }
    }
}