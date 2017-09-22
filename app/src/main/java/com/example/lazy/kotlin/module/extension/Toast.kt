package com.example.lazy.kotlin.module.extension

import android.widget.Toast

/**
 * Created by lazy on 2017/7/30.
 */

/**
 * Display the simple Toast message with the [Toast.LENGTH_SHORT] duration.
 *
 * @param message the message text resource.
 */
fun Any.toast(message: Int) = Toast.makeText(this.context, message, Toast.LENGTH_SHORT).show()

/**
 * Display the simple Toast message with the [Toast.LENGTH_SHORT] duration.
 *
 * @param message the message text resource.
 */
fun Any.toast(message: CharSequence) = Toast.makeText(this.context, message, Toast.LENGTH_SHORT).show()

/**
 * Display the simple Toast message with the [Toast.LENGTH_LONG] duration.
 *
 * @param message the message text resource.
 */
fun Any.longToast(message: Int) = Toast.makeText(this.context, message, Toast.LENGTH_LONG).show()

/**
 * Display the simple Toast message with the [Toast.LENGTH_LONG] duration.
 *
 * @param message the message text.
 */
fun Any.longToast(message: CharSequence) = Toast.makeText(this.context, message, Toast.LENGTH_LONG).show()