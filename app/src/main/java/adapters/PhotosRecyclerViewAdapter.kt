
package adapters

import android.graphics.Paint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import com.android.dreamolo.R
import kotlinx.android.synthetic.main.itemview_image.view.*
import org.json.JSONObject
import tools.Assistant


class PhotosRecyclerViewAdapter(
    private val myDataset: ArrayList<String>, var onItemClickListener: OnItemClickListener
) :
    RecyclerView.Adapter<PhotosRecyclerViewAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val products = LayoutInflater.from(parent.context).inflate(
            R.layout.itemview_image,
            parent,
            false
        ) as LinearLayout

        return MyViewHolder(
            products
        )
    }

    //    private var lastPosition = -1
    override fun getItemCount() = myDataset.size

    interface OnItemClickListener {

        fun onItemClickListener(position: Int, productInfo: String)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        holder.photos.oldPrice.paintFlags = holder.photos.oldPrice.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        val assistant = Assistant(holder.photos.context)
//        holder.photos.productsTitle.typeface = MyApp.getIranYekanRregularNum()
//        holder.photos.oldPrice.typeface = MyApp.getIranYekanRregularNum()
//        holder.photos.price.typeface = MyApp.getIranYekanRregularNum()

//        val data = JSONObject(myDataset[position])

//        Picasso.get().load(data.getJSONObject("image").getJSONObject("media")
//            .getString("media_full_path")).into(holder.photos.itemImage)
        setLayoutHeightWidth(assistant, holder)


        holder.photos.setOnClickListener {
            onItemClickListener.onItemClickListener(position, myDataset[position])
        }
    }

    private fun setLayoutHeightWidth(
        assistant: Assistant,
        holder: MyViewHolder
    ) {
//        assistant.setViewWidthByWidth(holder.photos.pht, 30.0, 100.0)
    }


    class MyViewHolder(val photos: LinearLayout) : RecyclerView.ViewHolder(photos)

    fun addItem(dataObj: String, index: Int) {
        myDataset.add(index, dataObj)
        notifyItemInserted(index)
    }
}