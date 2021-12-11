package com.project.aidoctor.ui.chat

import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.project.aidoctor.ApplicationClass
import com.project.aidoctor.databinding.LayoutRecyclerChatMeBinding
import com.project.aidoctor.databinding.LayoutRecyclerChatYouBinding

class ChatRecyclerAdapter(val viewModel:ChatViewModel):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var modelList=ArrayList<ChatModel>()

    private lateinit var itemClickListener : OnItemClickListener
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(viewType==0){
            val binding = LayoutRecyclerChatYouBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            return ChatYouViewHolder(binding)
        }else{
            val binding = LayoutRecyclerChatMeBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            return ChatMeViewHolder(binding)
        }


    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is ChatYouViewHolder -> holder.bind(modelList[position])
            is ChatMeViewHolder -> holder.bind(modelList[position])
        }

    }

    override fun getItemViewType(position: Int): Int {
        if(modelList[position].isMe){
            return 1
        }
        return 0
    }

    fun submitList(modelList:ArrayList<ChatModel>){
        this.modelList.addAll(modelList)
    }

    override fun getItemCount(): Int = modelList.size

    interface OnItemClickListener {
        fun onClick(v: View, position: Int)
    }
    fun setItemClickListener(onItemClickListener: OnItemClickListener) {
        this.itemClickListener = onItemClickListener
    }
    inner class ChatYouViewHolder(val binding: LayoutRecyclerChatYouBinding): RecyclerView.ViewHolder(binding.root),ButtonRecyclerAdapter.OnItemClickListener {


        private val buttonAdapter = ButtonRecyclerAdapter()
        fun bind(chatModel: ChatModel) {
            if (chatModel.thumbnail.isNotEmpty()) {
                binding.iv.visibility = View.VISIBLE
                Glide.with(ApplicationClass.instance).load(chatModel.thumbnail).into(binding.iv)
                binding.textview.visibility = View.GONE
                binding.rcvButton.visibility = View.GONE
                return
            }

            binding.iv.visibility = View.GONE
            binding.textview.visibility = View.VISIBLE

            binding.textview.text = Html.fromHtml(chatModel.text, Html.FROM_HTML_MODE_COMPACT)

            if(chatModel.listItem.isNullOrEmpty()){
                binding.rcvButton.visibility = View.GONE
                return
            }
            binding.rcvButton.visibility = View.VISIBLE
            val myModel = ArrayList<ButtonModel>()
            for(i in 0 until chatModel.listItem.size){
                myModel.add(ButtonModel(chatModel.listItem[i].value))
            }
            binding.rcvButton.apply {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
                adapter = buttonAdapter
            }
            buttonAdapter.setItemClickListener(this)
            buttonAdapter.clearList()
            buttonAdapter.submitList(myModel)
            buttonAdapter.notifyDataSetChanged()



        }

        override fun onClick(v: View, position: Int) {
            viewModel.send(buttonAdapter.getItemValue(position))
        }


    }
}
