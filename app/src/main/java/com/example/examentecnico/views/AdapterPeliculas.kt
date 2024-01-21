package com.example.examentecnico.views

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.examentecnico.R
import com.example.examentecnico.core.Constantes
import com.example.examentecnico.models.PeliculaModel
import com.google.android.material.progressindicator.CircularProgressIndicator
import java.security.AccessControlContext

class AdapterPeliculas(
    val context: Context,
    var listaPelicula: List<PeliculaModel>
): RecyclerView.Adapter<AdapterPeliculas.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val cvPelicula = itemView.findViewById(R.id.cvPelicula) as CardView
        val ivPoster = itemView.findViewById(R.id.ivPoster) as ImageView



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vista = LayoutInflater.from(parent.context).inflate(R.layout.item_rv_peliculas, parent, false)
        return ViewHolder(vista)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pelicula = listaPelicula[position]

        Glide
            .with(context)
            .load("${Constantes.BASE_URL_IMAGEN}${pelicula.poster}")
            .apply(RequestOptions().override(Constantes.IMAGEN_ANCHO, Constantes.IMAGEN_ALTO))
            .into((holder.ivPoster))
    }

    override fun getItemCount(): Int {
        return listaPelicula.size
    }
}