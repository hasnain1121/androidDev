package com.dengage.android.kotlin.nawaz.ui.adapter

import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import com.dengage.android.kotlin.nawaz.R
import com.dengage.android.kotlin.nawaz.ui.base.BaseRecyclerViewAdapter
import com.dengage.android.kotlin.nawaz.ui.base.BaseRecyclerViewHolder
import com.dengage.sdk.models.InboxMessage

/**
 * Created by Batuhan Coskun on 07 December 2020
 */
class InboxMessagesAdapter(
    items: List<InboxMessage>? = arrayListOf(),
    var inboxMessageCallback: InboxMessageCallback
) : BaseRecyclerViewAdapter(items) {
    override fun createNewViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(parent)

    inner class ViewHolder(
        parent: ViewGroup
    ) : BaseRecyclerViewHolder<InboxMessage>(parent, R.layout.recycler_item_inbox_message) {

        override fun bindItem(item: InboxMessage) {

            itemView.findViewById<AppCompatButton>(R.id.btn_mark_as_read).setOnClickListener {
                inboxMessageCallback.markAsRead(item.id)
            }
            itemView.findViewById<AppCompatButton>(R.id.btn_delete).setOnClickListener {
                inboxMessageCallback.delete(item.id)
            }

            itemView.findViewById<TextView>(R.id.tv_title).text = item.data.title
            itemView.findViewById<TextView>(R.id.tv_message).text = item.data.message
            itemView.findViewById<TextView>(R.id.tv_receive_date).text = item.data.receiveDate
            itemView.findViewById<TextView>(R.id.tv_is_clicked).text = item.isClicked.toString()

        }
    }

    interface InboxMessageCallback {
        fun markAsRead(id: String)
        fun delete(id: String)
    }
}