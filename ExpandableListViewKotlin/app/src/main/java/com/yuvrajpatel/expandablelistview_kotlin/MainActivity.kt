package com.yuvrajpatel.expandablelistview_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val header : MutableList<String> = ArrayList()
    val body : MutableList<MutableList<String>> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "ExpandableList"

        loadItems()
    }

    private fun loadItems() {
       val brand1 : MutableList<String> = ArrayList()

        brand1.add("Item 1")
        brand1.add("Item 2")
        brand1.add("Item 3")
        brand1.add("Item 4")
        brand1.add("Item 5")
        brand1.add("Item 6")
        brand1.add("Item 7")

        val brand2 : MutableList<String> = ArrayList()

        brand2.add("Item 1")
        brand2.add("Item 2")
        brand2.add("Item 3")
        brand2.add("Item 4")
        brand2.add("Item 5")
        brand2.add("Item 6")
        brand2.add("Item 7")

        val brand3 : MutableList<String> = ArrayList()

        brand3.add("Item 1")
        brand3.add("Item 2")
        brand3.add("Item 3")
        brand3.add("Item 4")
        brand3.add("Item 5")
        brand3.add("Item 6")
        brand3.add("Item 7")

        val brand4 : MutableList<String> = ArrayList()

        brand4.add("Item 1")
        brand4.add("Item 2")
        brand4.add("Item 3")
        brand4.add("Item 4")
        brand4.add("Item 5")
        brand4.add("Item 6")
        brand4.add("Item 7")

        val brand5 : MutableList<String> = ArrayList()

        brand5.add("Item 1")
        brand5.add("Item 2")
        brand5.add("Item 3")
        brand5.add("Item 4")
        brand5.add("Item 5")
        brand5.add("Item 6")
        brand5.add("Item 7")

        val brand6 : MutableList<String> = ArrayList()

        brand6.add("Item 1")
        brand6.add("Item 2")
        brand6.add("Item 3")
        brand6.add("Item 4")
        brand6.add("Item 5")
        brand6.add("Item 6")
        brand6.add("Item 7")

        val brand7 : MutableList<String> = ArrayList()

        brand7.add("Item 1")
        brand7.add("Item 2")
        brand7.add("Item 3")
        brand7.add("Item 4")
        brand7.add("Item 5")
        brand7.add("Item 6")
        brand7.add("Item 7")

        val brand8 : MutableList<String> = ArrayList()

        brand8.add("Item 1")
        brand8.add("Item 2")
        brand8.add("Item 3")
        brand8.add("Item 4")
        brand8.add("Item 5")
        brand8.add("Item 6")
        brand8.add("Item 7")

        val brand9 : MutableList<String> = ArrayList()

        brand9.add("Item 1")
        brand9.add("Item 2")
        brand9.add("Item 3")
        brand9.add("Item 4")
        brand9.add("Item 5")
        brand9.add("Item 6")
        brand9.add("Item 7")

        header.add("Brand 1")
        header.add("Brand 2")
        header.add("Brand 3")
        header.add("Brand 4")
        header.add("Brand 5")
        header.add("Brand 6")
        header.add("Brand 7")
        header.add("Brand 8")
        header.add("Brand 9")

        body.add(brand1)
        body.add(brand2)
        body.add(brand3)
        body.add(brand4)
        body.add(brand5)
        body.add(brand6)
        body.add(brand7)
        body.add(brand8)
        body.add(brand9)


        expandableListView.setAdapter(ExpandableListViewAdapter(this,expandableListView, header, body))

    }
}
