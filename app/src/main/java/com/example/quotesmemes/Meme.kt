package com.example.quotesmemes

import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import kotlinx.android.synthetic.main.activity_meme.*

class Meme : AppCompatActivity() {

    var currentMemeUrl: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meme)

        loadMeme()
    }

    private fun loadMeme(){

        // Instantiate the RequestQueue.
        progressBar.visibility = View.VISIBLE
//      val queue = Volley.newRequestQueue(this)
        val url = "https://meme-api.herokuapp.com/gimme/wholesomememes"

        // Request a string response from the provided URL.
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            { response ->
                currentMemeUrl = response.getString("url")
                Glide.with(this).load(currentMemeUrl).listener(object : RequestListener<Drawable> {

                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        progressBar.visibility = View.GONE
                        return false
                    }

                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: Target<Drawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {
                        progressBar.visibility = View.GONE
                        return false
                    }

                }).into(memeImageView)
            },
            {
                progressBar.visibility = View.GONE
                Toast.makeText(this, "something went wrong", Toast.LENGTH_LONG).show()
            })

        // Add the request to the RequestQueue.
        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest)
    }

    fun nextMeme(view: View) {
        loadMeme()
    }

    fun shareMeme(view: View) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT, "Hey checkout this cool meme i got from Reddit! $currentMemeUrl")
        val chooser = Intent.createChooser(intent, "Share this meme using...")
        startActivity(chooser)

    }

}