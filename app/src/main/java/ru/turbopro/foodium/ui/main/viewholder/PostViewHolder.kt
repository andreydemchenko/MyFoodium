package ru.turbopro.foodium.ui.main.viewholder

import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import ru.turbopro.foodium.R
import ru.turbopro.foodium.databinding.ItemPostBinding
import ru.turbopro.foodium.model.Post
import ru.turbopro.foodium.ui.main.adapter.PostListAdapter

/**
 * [RecyclerView.ViewHolder] implementation to inflate View for RecyclerView.
 * See [PostListAdapter]]
 */
class PostViewHolder(private val binding: ItemPostBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(post: Post, onItemClicked: (Post, ImageView) -> Unit) {
        binding.postTitle.text = post.title
        binding.postAuthor.text = post.author
        binding.imageView.load(post.imageUrl) {
            placeholder(R.drawable.ic_photo)
            error(R.drawable.ic_broken_image)
        }

        binding.root.setOnClickListener {
            onItemClicked(post, binding.imageView)
        }
    }
}
