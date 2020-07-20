package com.yuvrajpatel.mvvm_kotlin.model

class NicePlaces {

    private var placeName : String = ""
    private var placeImage : String = ""

    constructor()

    constructor(name : String, image : String) {
        this.placeName = name
        this. placeImage = image
    }

    fun setPlaceName(name : String){
        this.placeName = name
    }

    fun setPlaceImage(image : String){
        this.placeImage = image
    }

    fun getPlaceName() : String {
        return placeName
    }

    fun getPlaceImage() : String {
        return placeImage
    }

    override fun toString() : String {
        return "Name: " + getPlaceName() + " Image : " + getPlaceImage()
    }
}