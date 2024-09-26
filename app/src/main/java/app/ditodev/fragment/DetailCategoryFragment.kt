package app.ditodev.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class DetailCategoryFragment : Fragment() {
    private lateinit var tvCategoryFragment: TextView
    private lateinit var tvCategoryDesc: TextView
    private lateinit var btnProfile: TextView
    private lateinit var btnShowDialog: TextView
    var description: String? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_category, container, false)
    }

    companion object {
        var EXTRA_NAME = "extra_name"
        var EXTRA_DESCRIPTION = "extra_description"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvCategoryFragment = view.findViewById(R.id.category_name)
        tvCategoryDesc = view.findViewById(R.id.tv_category_description)
        btnProfile = view.findViewById(R.id.btn_profile)
        btnShowDialog = view.findViewById(R.id.btn_show_dialog)


        if (savedInstanceState != null) {
            val descFromBundle = savedInstanceState.getString(EXTRA_DESCRIPTION)
            description = descFromBundle
        }

        if (arguments != null) {
            val category = arguments?.getString(EXTRA_NAME)
            tvCategoryFragment.text = category
            tvCategoryDesc.text = description
        }


        btnShowDialog.setOnClickListener {
            val option = OptionDialogFragment()

            val fragManager = childFragmentManager
            option.show(fragManager, OptionDialogFragment::class.java.simpleName)
        }

        btnProfile.setOnClickListener {
            val intent = Intent(requireActivity(), ProfileActivity::class.java)
            startActivity(intent)
        }
    }

    internal var optionDialogListener: OptionDialogFragment.OnOptionDialogListener =
        object : OptionDialogFragment.OnOptionDialogListener {
            override fun onOptionChosen(coach: String?) {
                Toast.makeText(requireActivity(), coach, Toast.LENGTH_SHORT).show()
            }
        }
}