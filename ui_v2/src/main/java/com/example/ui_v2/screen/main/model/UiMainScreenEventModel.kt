package com.example.ui_v2.screen.main.model

internal data class UiMainScreenEventModel(
    val id: Int,
)

internal sealed class MainContentSlot {
    data class MainEventsCarousel(val eventList: List<Int>) : MainContentSlot()

    data class SoonEventsCarousel(val eventList: List<Int>) : MainContentSlot()

    data class Event(val id: Int) : MainContentSlot()

    data class CommunitiesSuggestionRail(val title: String, val communitiesList: List<Int>) :
        MainContentSlot()

    data class PeopleSuggestionRail(val peopleList: List<Int>) : MainContentSlot()

    data object FilterBlock : MainContentSlot()
}
