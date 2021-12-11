package com.project.aidoctor.ui.chat

import android.text.Html
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.core.net.toUri
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.project.aidoctor.ApplicationClass
import com.project.aidoctor.data.remote.chat.ChatService
import com.project.aidoctor.data.repository.chat.ChatRepository
import com.project.aidoctor.databinding.LayoutRecyclerChatYouBinding
import com.project.aidoctor.di.viewModelModule
import com.project.aidoctor.util.toast
import org.koin.android.compat.ViewModelCompat
import org.koin.androidx.viewmodel.ext.android.viewModel

