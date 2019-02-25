package adapters

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.android.dreamolo.R
import kotlinx.android.synthetic.main.itemview_category_single_item.view.*
import tools.Assistant


class SingleCategoryRecyclerViewAdapter(
    private val myDataset: ArrayList<String>, var onItemClickListener: OnItemClickListener
) :
    RecyclerView.Adapter<SingleCategoryRecyclerViewAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val products = LayoutInflater.from(parent.context)
            .inflate(R.layout.itemview_category_single_item, parent, false) as LinearLayout

        return MyViewHolder(
            products
        )
    }

    override fun getItemCount() = myDataset.size

    interface OnItemClickListener {
        fun onItemClickListener(position: Int, productInfo: String, view: View)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val assistant = Assistant(holder.category.context)
//        setLayoutHeightWidth(assistant, holder)

        holder.category.setOnClickListener {
            onItemClickListener.onItemClickListener(position, myDataset[position], holder.category.categoryView)

            if (position == holder.adapterPosition)
            holder.category.categoryView.background =
                holder.category.context.resources.getDrawable(R.drawable.blue_shape_medium_radius)
            holder.category.categoryText.setTextColor(Color.WHITE)
        }

    }

    private fun setLayoutHeightWidth(assistant: Assistant, holder: MyViewHolder) {
        assistant.setViewWidthByWidth(holder.category.categoryView, 15.0, 100.0)
//        assistant.setViewHeightByHeight(holder.category.recentDreams, 15.0, 100.0)
    }

    class MyViewHolder(val category: LinearLayout) : RecyclerView.ViewHolder(category)

    fun addItem(dataObj: String, index: Int) {
        myDataset.add(index, dataObj)
        notifyItemInserted(index)
    }
}