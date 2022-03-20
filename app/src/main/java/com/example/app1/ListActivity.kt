package com.example.app1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class ListActivity : AppCompatActivity() {
    val place= arrayListOf<Place>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        initData()
        val recycler = findViewById<RecyclerView>(R.id.recycler)
        recycler.layoutManager=LinearLayoutManager(this)
        recycler.adapter=PlaceAdapter(place)
    }

    private fun initData() {
        for (i in 0..2){
            place.add(Place().apply {
                name="长白山"
                description="长白山脉主峰位于吉林省白山市长白朝鲜族自治县，是鸭绿江、松花江和图们江的发源地。是中国满族的发祥地和满族文化圣山。长白山脉的“长白”二字还有一个美好的寓意，即为长相守，到白头，代表着人们对忠贞与美满爱情的向往与歌颂。"
                avatar=R.mipmap.changbaishan
                province="吉林省"
            })
            place.add(Place().apply {
                name="达古冰川"
                description="达古冰山风景名胜区位于中国四川阿坝藏族羌族自治州黑水县境内，东经102.44.15-102.52.46，北纬32.12.30-32.17.06，系罕见的现代山地冰川。风景游览区规划面积210平方公里、自然保护区面积632平方公里，是阿坝州继九寨沟、黄龙后开发的又一精品景区，是镶嵌在中国·四川·阿坝·大九寨国际旅游区的一颗璀璨明珠。"
                avatar=R.mipmap.dagu
                province="四川省"
            })
            place.add(Place().apply {
                name="洱海"
                description="洱海，在古代有“叶榆水”、“叶榆河”、“叶榆泽”、“西洱河”、“洱河”、“昆弥川”等名称。洱海之所以最终以“洱”为名，要么说它“形若人耳”，要么说它“如月抱珥”，因而得名。"
                avatar=R.mipmap.ehai
                province="云南省"
            })
            place.add(Place().apply {
                name="故宫"
                description="北京故宫是中国明清两代的皇家宫殿，旧称紫禁城，位于北京中轴线的中心。北京故宫以三大殿为中心，占地面积约72万平方米，建筑面积约15万平方米，有大小宫殿七十多座，房屋九千余间。"
                avatar=R.mipmap.gugong
                province="北京市"
            })
            place.add(Place().apply {
                name="鼓浪屿"
                description="鼓浪屿隶属于福建省厦门市，北纬N24°26′55.25″ 东经E118°03′43.55″。位于厦门半岛西南隅，与厦门岛隔海相望，只隔一条宽600米的鹭江"
                avatar=R.mipmap.gulangyu
                province="福建省"
            })
            place.add(Place().apply {
                name="喀纳斯"
                description="“喀纳斯”是蒙古语，意为“美丽而神秘的湖”。喀纳斯湖雪峰耸峙绿坡墨林，湖光山色美不胜收，被誉为“人间仙境、神的花园”。"
                avatar=R.mipmap.kanasi
                province="新疆"
            })

        }
    }
    fun onClick1(view: View){
        AlertDialog.Builder(this)
            .setTitle("详细信息")
            .setMessage("请稍后")
            .setNegativeButton("关闭"){d,w->
                Toast.makeText(this,"已取消",Toast.LENGTH_LONG).show()
            }
            .setPositiveButton("确定"){d,w->
                More()
            }
            .show()
    }

    private fun More() {
        val process = findViewById<ProgressBar>(R.id.progress)
        process.visibility = View.GONE
        process.progress = 0
        // TODO: 请求网络 耗时
        val timer = Timer()
        val context = this
        val task = object : TimerTask(){
            override fun run() {
                process.progress = process.progress + 1
                if(process.progress == 5){
                    timer.cancel()
                    Handler(Looper.getMainLooper()).post {
                        process.visibility = View.GONE
                        startActivity(Intent(context,MoreActivity::class.java))
                    }
                }
            }

        }
        timer.schedule(task,0,1000)
    }
}