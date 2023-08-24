package com.ryz.myapplication.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ryz.myapplication.MainActivity
import com.ryz.myapplication.R
import com.ryz.myapplication.common.customToolbar
import com.ryz.myapplication.databinding.FragmentProductInputBinding

class ProductInputFragment : Fragment() {
    private var _binding: FragmentProductInputBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProductInputBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpToolbar()
        setUpMenu()

    }

    private fun setUpToolbar() {
        binding.layoutToolbars.topAppBar.customToolbar(
            activity as MainActivity,
            title = getString(R.string.product_input_title),
            isShowMenu = true,
            menuId = R.menu.product_list
        )
    }

    private fun setUpMenu() {
        binding.layoutToolbars.topAppBar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.product_list -> {
                    findNavController().navigate(R.id.action_productInputFragment_to_productListFragment)
                    true
                }

                else -> false
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}