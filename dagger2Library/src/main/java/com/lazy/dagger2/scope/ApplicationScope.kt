package com.lazy.dagger2.scope

import javax.inject.Singleton

/**
 * A scoping annotation to permit objects whose lifetime should
 * conform to the life of the activity to be memorized in the
 * correct component.
 */
@Singleton
@Target(AnnotationTarget.CLASS,
        AnnotationTarget.FILE,
        AnnotationTarget.FIELD,
        AnnotationTarget.FUNCTION,
        AnnotationTarget.PROPERTY_GETTER,
        AnnotationTarget.PROPERTY_SETTER)
@Retention(AnnotationRetention.SOURCE)
@MustBeDocumented
annotation class ApplicationScope