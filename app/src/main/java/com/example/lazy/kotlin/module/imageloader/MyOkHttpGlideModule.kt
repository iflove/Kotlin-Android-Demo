package com.example.lazy.kotlin.module.imageloader

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.Registry
import com.bumptech.glide.integration.okhttp3.OkHttpGlideModule
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool
import com.bumptech.glide.load.engine.cache.ExternalCacheDiskCacheFactory
import com.bumptech.glide.load.engine.cache.LruResourceCache

class MyOkHttpGlideModule : OkHttpGlideModule() {

    override fun applyOptions(context: Context, builder: GlideBuilder) {
        super.applyOptions(context, builder)
        val maxMemory = Runtime.getRuntime().maxMemory().toInt()
        val memoryCacheSize = maxMemory / 8
        builder.setMemoryCache(LruResourceCache(memoryCacheSize.toLong()))
        val diskCacheSize = 1024 * 1024 * 10
        val factory = ExternalCacheDiskCacheFactory(context, "Vending", diskCacheSize)
        builder.setDiskCache(factory)
        //builder.setDecodeFormat(DecodeFormat.PREFER_RGB_565)
        builder.setBitmapPool(LruBitmapPool(memoryCacheSize.toLong()))
        // Just DO: 2017/1/10
    }

    override fun registerComponents(context: Context, glide: Glide, registry: Registry) {
    }
}
