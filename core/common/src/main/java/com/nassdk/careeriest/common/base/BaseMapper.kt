package com.nassdk.careeriest.common.base

interface BaseMapper<FROM, TO> {
    fun map(from: FROM): TO
}
