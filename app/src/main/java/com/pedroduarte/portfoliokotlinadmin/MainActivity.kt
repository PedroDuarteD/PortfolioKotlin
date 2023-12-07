    package com.pedroduarte.portfoliokotlinadmin

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.pedroduarte.portfoliokotlinadmin.model.ProjectModel
import com.pedroduarte.portfoliokotlinadmin.recycler.ProjectsPortfolio
import org.json.JSONArray
import org.json.JSONObject

    class MainActivity : AppCompatActivity() {

    private var projects = ArrayList<ProjectModel>();
    private lateinit var listReccler: RecyclerView
    private lateinit var btn_add_project: FloatingActionButton
    private lateinit var appBar: Toolbar

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        appBar = findViewById(R.id.my_toolbar)
        listReccler = findViewById(R.id.recycler)
        btn_add_project= findViewById(R.id.btn_add)

        appBar.setTitle("Projects")


        btn_add_project.setOnClickListener {
            startActivity(Intent(applicationContext, AddProject::class.java))
        }


        val queue = Volley.newRequestQueue(applicationContext)
        val request =  StringRequest(Request.Method.GET, "https://backend.pedroduarte.online/api/allprojects?onlyproduction=false",
            {


              var json =  JSONArray(it)

                (0 until json.length()).forEach{
                    val project = json.getJSONObject(it)
                    projects.add(ProjectModel(1,project.getString("name"),project.getString("desc"),"Android",true))
                    val adapter = ProjectsPortfolio(projects)

                    listReccler.adapter = adapter
                    listReccler.layoutManager = LinearLayoutManager(applicationContext)
                }

            },
            {
                Toast.makeText(applicationContext,"Error",Toast.LENGTH_SHORT).show()
            })
        queue.add(request)
        

    }
}