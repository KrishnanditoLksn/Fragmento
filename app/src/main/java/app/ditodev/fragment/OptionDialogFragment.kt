package app.ditodev.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.DialogFragment


class OptionDialogFragment : DialogFragment() {
    private lateinit var btnChoose: Button
    private lateinit var btnClose: Button
    private lateinit var rgOptions: RadioGroup
    private lateinit var rbMessi: RadioButton
    private lateinit var rbEvan: RadioButton
    private lateinit var rbLf: RadioButton
    private lateinit var rbKm: RadioButton
    private var optionDialogListener: OnOptionDialogListener? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_option_dialog, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        btnChoose = view.findViewById(R.id.btn_choose)
        btnClose = view.findViewById(R.id.btn_close)
        rgOptions = view.findViewById(R.id.options)
        rbMessi = view.findViewById(R.id.rb_messi)
        rbEvan = view.findViewById(R.id.rb_evan)
        rbLf = view.findViewById(R.id.rb_lf)
        rbKm = view.findViewById(R.id.rb_km)
        super.onViewCreated(view, savedInstanceState)

        btnChoose.setOnClickListener {
            val checkedRadioButtonId = rgOptions.checkedRadioButtonId
            if (checkedRadioButtonId != -1) {
                var coach: String? = null
                when (checkedRadioButtonId) {
                    R.id.rb_messi -> coach = rbMessi.text.toString().trim()
                    R.id.rb_evan -> coach = rbEvan.text.toString().trim()
                    R.id.rb_lf -> coach = rbLf.text.toString().trim()
                    R.id.rb_km -> coach = rbKm.text.toString().trim()
                }
                optionDialogListener?.onOptionChosen(coach)
                dialog?.dismiss()
            }
        }

        btnClose.setOnClickListener {
            dialog?.cancel()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val fragment = parentFragment

        if (fragment is DetailCategoryFragment) {
            this.optionDialogListener = fragment.optionDialogListener
        }
    }

    interface OnOptionDialogListener {
        fun onOptionChosen(coach: String?)
    }
}