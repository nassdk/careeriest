package com.nassdk.careeriest.common.extensions

import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/**
 * Функция автоматически определяет способ получения данных из Bundle,
 * по типу, который нужно вернуть в клиенту.
 *
 * @receiver предполагается что это argumentsDelegate во фрагментах, но может быть и любым другим.
 *
 * @param key - ключ хранения параметра в Bundle
 *
 * @param T - тип получаемого значения.
 *
 * @return nullable
 * */
inline fun <reified T> Bundle.getValue(key: String): T? {
    return get(key) as? T
}

/**
 * @param default  вернется если
 * @see getValue вернет null
 * */
inline fun <reified T> Bundle.getValue(key: String, default: T): T {
    return getValue<T>(key) ?: default
}


/**
 * функция для запроса not null value
 * */
inline fun <reified T : Any> Bundle.getRequiredValue(key: String): T {
    return requireNotNull(getValue<T>(key)) {
        "No value found by key: $key. Check argument KEY and value type"
    }
}


inline fun <T : Fragment> T.withArgs(
    argsBuilder: Bundle.() -> Unit,
): T =
    this.apply {
        arguments = Bundle().apply(argsBuilder)
    }
