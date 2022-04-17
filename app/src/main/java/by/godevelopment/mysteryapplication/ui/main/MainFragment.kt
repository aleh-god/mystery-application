package by.godevelopment.mysteryapplication.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import by.godevelopment.mysteryapplication.MainActivity
import by.godevelopment.mysteryapplication.R
import by.godevelopment.mysteryapplication.commons.TAG
import by.godevelopment.mysteryapplication.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var viewModelFactory: MainViewModelFactory
    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        val mainActivity = requireActivity() as MainActivity
        viewModelFactory = MainViewModelFactory(mainActivity.coldStartHandler)
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
        setupButton()
        setupEvent()
        return binding.root
    }

    private fun setupButton() {
        binding.btnReset.setOnClickListener {
            Log.i(TAG, "setOnClickListener: invoke")
            viewModel.resetCounterColdStart()
        }
    }

    private fun setupEvent() {
        lifecycleScope.launchWhenStarted {
            Log.i(TAG, "setupEvent: launchWhenStarted")
            viewModel.uiEvent.collect {
                Log.i(TAG, "setupEvent: viewModel.uiEvent.collect $it")
                Toast
                    .makeText(
                        requireContext(),
                        getString(R.string.fragment_message_main),
                        Toast.LENGTH_LONG
                    )
                    .show()
            }
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}