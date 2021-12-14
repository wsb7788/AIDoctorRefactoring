package com.project.faily.di


import com.project.aidoctor.data.remote.admin.AdminService
import com.project.aidoctor.data.remote.chat.ChatService
import com.project.aidoctor.data.remote.chat_admin.ChatAdminService
import com.project.aidoctor.data.remote.home.HomeService
import com.project.aidoctor.data.remote.login.LoginService
import com.project.aidoctor.data.remote.notification.NotificationService
import com.project.aidoctor.data.remote.profile.ProfileService
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


const val PRODUCTION_URL = "http://13.209.10.30:3000/"
const val TEST_URL = "http://3.134.232.146:8000/"
private val base_url: String = TEST_URL

fun getBaseUrl() = base_url

val networkModule: Module = module {
/*    fun provideHeaderInterceptor(sharedPreferenceManager: SharedPreferencesManager) =
        Interceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader("jwt_token", sharedPreferenceManager.getJwtToken())
                .build()

            chain.proceed(request)
        }
    fun provideOkHttpClient(
        headerInterceptor: Interceptor
    ) = OkHttpClient.Builder()
        .readTimeout(5000, TimeUnit.MILLISECONDS)
        .connectTimeout(5000, TimeUnit.MILLISECONDS)
        .addInterceptor(headerInterceptor)
        .build()


    fun provideRetrofit(okHttpClient: OkHttpClient):Retrofit = Retrofit.Builder()
        .baseUrl(getBaseUrl())
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()*/
    fun provideRetrofit():Retrofit = Retrofit.Builder()
        .baseUrl(getBaseUrl())
        .addConverterFactory(GsonConverterFactory.create())
        .build()



    fun provideLoginService(retrofit: Retrofit): LoginService =
        retrofit.create(LoginService::class.java)
    fun provideHomeService(retrofit: Retrofit): HomeService =
        retrofit.create(HomeService::class.java)
   fun provideChatService(retrofit: Retrofit): ChatService =
        retrofit.create(ChatService::class.java)
   fun provideProfileService(retrofit: Retrofit): ProfileService =
        retrofit.create(ProfileService::class.java)
   fun provideAdminService(retrofit: Retrofit): AdminService =
        retrofit.create(AdminService::class.java)
   fun provideChatAdminService(retrofit: Retrofit): ChatAdminService =
        retrofit.create(ChatAdminService::class.java)
   fun provideNotificationService(retrofit: Retrofit): NotificationService =
        retrofit.create(NotificationService::class.java)

/*
    single { provideHeaderInterceptor(get()) }
    single { provideOkHttpClient(get()) }
    single { provideRetrofit(get()) }
*/

    single { provideRetrofit() }


    single { provideLoginService(get()) }
    single { provideHomeService(get()) }
    single { provideChatService(get()) }
    single { provideProfileService(get()) }
    single { provideAdminService(get()) }
    single { provideChatAdminService(get()) }
    single { provideNotificationService(get()) }

}

