package com.example.lazy.kotlin.module.annotation


@MustBeDocumented
@Target(AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.RUNTIME)
annotation class Required
