package com.diegoveega.evlab2_pdm_00046317.Fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.diegoveega.evlab2_pdm_00046317.R
import kotlinx.android.synthetic.main.fragment_slide.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "imagen"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [SlideFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [SlideFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class SlideFragment() : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var listener: OnFragmentInteractionListener? = null
    private lateinit var imagenSlide: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_slide, container, false)
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onStart() {
        super.onStart()
        imagenSlide = imagen

        if(param1 == "1"){
            imagenSlide.setImageResource(R.drawable.abc_ab_share_pack_mtrl_alpha)
        }else if (param1 == "2"){
            imagenSlide.setImageResource(R.drawable.abc_btn_check_material)
        }else if (param1 == "3"){
            imagenSlide.setImageResource(R.drawable.abc_btn_radio_material)
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SlideFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                SlideFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                    }
                }
    }
}
