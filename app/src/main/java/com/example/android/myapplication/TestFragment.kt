package com.example.android.myapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class ArticleFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)

        arguments?.getString(INTENT_EXTRA)?.let {

        }
    }

    companion object {

        const val INTENT_EXTRA = "asda"
        const val INTENT_EXTRA1 = "asda1"
        const val INTENT_EXTRA2 = "asda2"
        const val INTENT_EXTRA3 = "asda3"
        const val INTENT_EXTRA4 = "asda4"


        fun newInstance(name: String): ArticleFragment {
            val fragment = ArticleFragment()
            val bundle = Bundle()
            bundle.putString(INTENT_EXTRA, name)
            fragment.arguments = bundle

            return fragment
        }
    }
}