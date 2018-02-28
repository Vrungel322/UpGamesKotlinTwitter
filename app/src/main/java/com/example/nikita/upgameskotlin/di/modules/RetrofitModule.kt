package com.example.nikita.upgameskotlin.di.modules

import com.example.nikita.upgameskotlin.BuildConfig
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by nikita on 28.02.2018.
 */
@Module
class RetrofitModule {

  @Provides
  @Singleton
  @Named("Sugarman") internal fun provideRetrofit(
      converterFactory: Converter.Factory, okClient: OkHttpClient): Retrofit {
    return Retrofit.Builder().baseUrl("baseUrl://")
        //return new Retrofit.Builder().baseUrl(Config.SERVER_URL)
        .client(okClient)        .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(io.reactivex.schedulers.Schedulers.io()))

        .addConverterFactory(converterFactory)
        .build()
  }

  @Provides
  @Singleton internal fun provideConverterFactory(gson: Gson): Converter.Factory {
    return GsonConverterFactory.create(gson)
  }

  @Provides
  @Singleton internal fun provideGson(): Gson {
    return GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
        .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
        .serializeNulls()
        .create()
  }

  @Provides
  @Singleton internal fun provideOkClient(httpLoggingInterceptor: HttpLoggingInterceptor,
//      cache: Cache,
//      @Named("CacheInterceptor") cacheInterceptor: Interceptor,
//      @Named("OfflineCacheInterceptor") offlineCacheInterceptor: Interceptor,
      @Named("HeaderInterceptor") headerInterceptor: Interceptor): OkHttpClient {
    return OkHttpClient.Builder().readTimeout(30, TimeUnit.SECONDS)
        .addInterceptor(headerInterceptor)
        .addInterceptor(httpLoggingInterceptor)

        //To turn on caching response - uncomment next three lines
        //.addInterceptor(offlineCacheInterceptor)
        //.addNetworkInterceptor(cacheInterceptor)
        //.cache(cache)
        .build()
  }

  @Provides
  @Singleton internal fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
    val interceptor = HttpLoggingInterceptor { message -> Timber.tag("response").d(message) }
    interceptor.level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.BODY
    return interceptor
  }

  @Provides
  @Singleton
  @Named("HeaderInterceptor") internal fun provideHeaderInterceptor(): Interceptor {
    Timber.e("Got into interceptor")
    return Interceptor { chain ->
      val original = chain.request()
      val request: Request
      val requestBuilder = original.newBuilder()
      // .header("content-type", "application/json");

//      if (!TextUtils.isEmpty(token)) {
//        requestBuilder.header(Constants.AUTHORIZATION, Constants.BEARER + token)
//        requestBuilder.header(Constants.TIMEZONE, TimeZone.getDefault().id)
//        requestBuilder.header(Constants.TIMESTAMP, System.currentTimeMillis().toString() + "")
//        requestBuilder.header(Constants.VERSION, DeviceHelper.getAppVersionName())
//        requestBuilder.header(Constants.IMEI, SharedPreferenceHelper.getIMEI())
//      }

      request = requestBuilder.build()
      return@Interceptor chain.proceed(request)


    }
  }

  /**
   * For Cache
   */
//  @Provides
//  @Singleton internal fun provideCache(context: Context): Cache? {
//    var cache: Cache? = null
//    try {
//      cache = Cache(File(context.cacheDir, "http-cache"), (10 * 1024 * 1024).toLong()) // 10 MB
//    } catch (e: Exception) {
//      Timber.e(e, "Could not create Cache!")
//    }
//
//    return cache
//  }
//
//  @Provides
//  @Singleton
//  @Named("CacheInterceptor") internal fun provideCacheInterceptor(): Interceptor {
//    return { chain ->
//      val request = chain.request()
//      var response = chain.proceed(chain.request())
//
//      if (IgnoreRequestUtils.ignoreRequests(request, "POST",
//          SharedPreferenceHelper.getBaseUrl() + "v2/users")) {
//        val cacheControl = CacheControl.Builder().build()
//        response = response.newBuilder()
//            .removeHeader("Pragma")
//            .header("Cache-Control", cacheControl.toString())
//            .build()
//      }
//      response
//    }
//  }
//
//  @Provides
//  @Singleton
//  @Named("OfflineCacheInterceptor") internal fun provideOfflineCacheInterceptor(
//      context: Context): Interceptor {
//    return { chain ->
//      var request = chain.request()
//      if (!DeviceHelper.isNetworkConnected()) {
//        val cacheControl = CacheControl.Builder().maxStale(7, TimeUnit.DAYS).build()
//        request = request.newBuilder().cacheControl(cacheControl).build()
//      }
//      chain.proceed(request)
//    }
//  }
}