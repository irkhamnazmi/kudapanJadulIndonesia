package com.example.kudapanjadul

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvSnack: RecyclerView
    private var list: ArrayList<Snack> =  arrayListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvSnack = findViewById(R.id.rv_snack)
        rvSnack.setHasFixedSize(true)

        list.addAll(SnackData.listData)
        showRecyclerList()


    }

    private fun showRecyclerList() {
       rvSnack.layoutManager = LinearLayoutManager(this)
       val listSnackAdapter = ListSnackAdapter(list)
       rvSnack.adapter = listSnackAdapter

        listSnackAdapter.setOnclickCallback(object : ListSnackAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Snack) {
                showSelectedSnack(data)
            }
        })
    }

    private fun showSelectedSnack(snack: Snack) {
        val moveDetailIntent = Intent(this@MainActivity,DetailSnackActivity::class.java)
        moveDetailIntent.putExtra(DetailSnackActivity.EXTRA_NAME,snack.name)
        moveDetailIntent.putExtra(DetailSnackActivity.EXTRA_DIST_AREA,snack.distArea)
        moveDetailIntent.putExtra(DetailSnackActivity.EXTRA_LINK,snack.link)
        moveDetailIntent.putExtra(DetailSnackActivity.EXTRA_DETAIL,snack.detail)
        moveDetailIntent.putExtra(DetailSnackActivity.EXTRA_PHOTO,snack.photo)
        startActivity(moveDetailIntent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_item,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMove(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMove(selectedMove: Int) {
        when (selectedMove){
            R.id.about_me ->{
                val moveAboutMe = Intent(this@MainActivity,AboutActivity::class.java)
                startActivity(moveAboutMe)
            }
        }
    }
}