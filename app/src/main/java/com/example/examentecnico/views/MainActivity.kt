package com.example.examentecnico.views

import android.app.Activity
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.examentecnico.R
import com.example.examentecnico.viewmodels.PeliculasViewModel

class MainActivity : AppCompatActivity(){

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: PeliculasViewModel
    private lateinit var adapterPeliculas: AdapterPeliculas

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[PeliculasViewModel::class.java]



        viewModel.listaPeliculas.observe(this){
            adapterPeliculas.listaPelicula = it
            adapterPeliculas.notifyDataSetChanged()
            }
        binding.cvCartelera.setOnClickListener{
            viewModel.obtenerCartelera()
            cambiarColorBotom("car")
        }
        binding.cvPopulare.setOnClickListener{
            viewModel.obtenerPopulares()
            cambiarColorBotom("pop")
        }
        viewModel.obtenerCartelera()
    }
    private fun cambiarColorBotom(boton: String){
        when(boton) {
            "car" ->{
                binding.cvCartelera.setCardBackgroundColor(resources.getColor(R.color.verde_200))
                binding.cvPopulares.setCardBackgroundColor(resources.getColor(R.color.azul_200))
            }
            "pop"->{
                binding.cvCartelera.setCardBackgroundColor(resources.getColor(R.color.azul_200))
                binding.cvPopulares.setCardBackgroundColor(resources.getColor(R.color.verde_200))
            }
        }
    }
    }

