package com.dr1009.app.bsvp

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.observe
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.dr1009.app.bsvp.databinding.ActivityMainBinding
import com.dr1009.app.bsvp.databinding.RecyclerCardAnimalBinding

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        val adapter = MainRecyclerViewAdapter()
        binding.recyclerView.adapter = adapter
        viewModel.animalList.observe(this, adapter::submitList)

        binding.fab.setOnClickListener {
            val bottomSheetDialog = MainBottomSheetDialogFragment.newInstance()
            bottomSheetDialog.show(supportFragmentManager, MainBottomSheetDialogFragment.TAG)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private inner class MainRecyclerViewAdapter :
        ListAdapter<Animal, SimpleViewHolder<RecyclerCardAnimalBinding>>(
            object : DiffUtil.ItemCallback<Animal>() {
                override fun areItemsTheSame(oldItem: Animal, newItem: Animal): Boolean =
                    oldItem.id == newItem.id

                override fun areContentsTheSame(oldItem: Animal, newItem: Animal): Boolean =
                    oldItem == newItem
            }
        ) {
        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): SimpleViewHolder<RecyclerCardAnimalBinding> =
            SimpleViewHolder(parent.inflate(R.layout.recycler_card_animal))

        override fun onBindViewHolder(
            holder: SimpleViewHolder<RecyclerCardAnimalBinding>,
            position: Int
        ) {
            holder.binding?.let {
                it.animal = getItem(position)
                it.executePendingBindings()
            }
        }
    }
}
