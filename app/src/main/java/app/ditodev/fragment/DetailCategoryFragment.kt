package app.ditodev.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
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
        tvCategoryDesc= view.findViewById(R.id.tv_category_description)
        btnProfile= view.findViewById(R.id.btn_profile)
        btnShowDialog= view.findViewById(R.id.btn_show_dialog)


        if (savedInstanceState != null) {
            val descFromBundle = savedInstanceState.getString(EXTRA_DESCRIPTION)
            description = descFromBundle
        }

        if (arguments != null) {
            val category = arguments?.getString(EXTRA_NAME)
            tvCategoryFragment.text = category
            tvCategoryDesc.text = description
        }
    }
}