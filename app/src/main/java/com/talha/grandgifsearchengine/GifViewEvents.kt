package com.talha.grandgifsearchengine

import com.talha.grandgifsearchengine.data.Data

sealed class GifViewEvents {
    data class Edit(val sampleEntity: Data) : GifViewEvents()
    data class Remove(val sampleEntity: Data) : GifViewEvents()
    object InsertItemHeader : GifViewEvents()
    object InsertItemFooter : GifViewEvents()
}
