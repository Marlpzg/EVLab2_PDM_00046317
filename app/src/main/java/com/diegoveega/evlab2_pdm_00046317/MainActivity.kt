package com.diegoveega.evlab2_pdm_00046317

import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.diegoveega.evlab2_pdm_00046317.Fragments.ButtonsFragment
import com.diegoveega.evlab2_pdm_00046317.Fragments.SlideFragment
import com.diegoveega.evlab2_pdm_00046317.Interfaces.Communication

class MainActivity : AppCompatActivity(), SlideFragment.OnFragmentInteractionListener, ButtonsFragment.OnFragmentInteractionListener, Communication{

    private var numero = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun comunicar(cadena: String){

        if (cadena == "Siguiente"){

            numero = numero + 1

            if (numero > 3){
                numero = 1
            }

        }else{

            numero = numero - 1

            if (numero < 1){
                numero = 3
            }

        }

        var datos = Bundle()

         datos.putString("imagen", numero.toString())

        var frag = SlideFragment().apply {
            arguments = datos
        }

        supportFragmentManager.beginTransaction().replace(R.id.slide_container, frag).addToBackStack(null).commit()

    }

    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
