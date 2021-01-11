package com.palepeak.threadsexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.listitem.view.*

class MyAdapter(private val dataSet: List<MainActivity.ListEntries>) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView = view.textView
        val textView2 = view.textView2
        val switch = view.switch1

    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.listitem, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.textView.text = dataSet[position].entry1
        viewHolder.textView2.text = dataSet[position].entry2

        viewHolder.switch.setOnCheckedChangeListener {
                compoundButton, b ->  dataSet[position].switched = b
        }
        viewHolder.switch.isChecked = dataSet[position].switched
    }

    override fun getItemCount() = dataSet.size

}