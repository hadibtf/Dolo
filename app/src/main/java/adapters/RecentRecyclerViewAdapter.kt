package adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import com.android.dreamolo.R
import kotlinx.android.synthetic.main.itemview_dreams.view.*
import tools.Assistant


class RecentRecyclerViewAdapter(
    private val myDataset: ArrayList<String>, var onItemClickListener: OnItemClickListener
) :
    RecyclerView.Adapter<RecentRecyclerViewAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val products = LayoutInflater.from(parent.context)
            .inflate(R.layout.itemview_dreams, parent, false) as LinearLayout

        return MyViewHolder(
            products
        )
    }

    override fun getItemCount() = myDataset.size

    interface OnItemClickListener {
        fun onItemClickListener(position: Int, productInfo: String)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val assistant = Assistant(holder.ivRecentDreams.context)
        setLayoutHeightWidth(assistant, holder)

        holder.ivRecentDreams.setOnClickListener {
            onItemClickListener.onItemClickListener(position, myDataset[position])
        }
    }

    private fun setLayoutHeightWidth(assistant: Assistant, holder: MyViewHolder) {
//        assistant.setViewWidthByWidth(holder.ivRecentDreams.recentDreams, 85.0, 100.0)
        assistant.setViewHeightByHeight(holder.ivRecentDreams.recentDreams, 18.0, 100.0)
    }

    class MyViewHolder(val ivRecentDreams: LinearLayout) : RecyclerView.ViewHolder(ivRecentDreams)

    fun addItem(dataObj: String, index: Int) {
        myDataset.add(index, dataObj)
        notifyItemInserted(index)
    }
}