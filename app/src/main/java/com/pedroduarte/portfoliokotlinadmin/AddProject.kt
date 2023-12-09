package com.pedroduarte.portfoliokotlinadmin

import android.annotation.SuppressLint
import android.content.ContextParams
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class AddProject : AppCompatActivity() {

    private lateinit var edit_name : EditText
    private lateinit var edit_desc : EditText

    private lateinit var check_fav : CheckBox
    private lateinit var check_show : CheckBox
    private lateinit var check_prod : CheckBox

    private lateinit var btn_save : Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_project)

        edit_name = findViewById(R.id.edit_name)
        edit_desc = findViewById(R.id.edit_desc)
        check_fav = findViewById(R.id.check_fav)
        check_show = findViewById(R.id.check_show)
        check_prod = findViewById(R.id.check_produ)
        btn_save = findViewById(R.id.btn_add)

        btn_save.setOnClickListener {
            if(edit_name.text.isNotEmpty() && edit_desc.text.isNotEmpty()){
                    val request = Volley.newRequestQueue(applicationContext)
                val r =object :StringRequest(Request.Method.POST,"https://backend.pedroduarte.online/api/add_project",{
                    Toast.makeText(applicationContext, "Success",Toast.LENGTH_SHORT).show()

                },{
                    Toast.makeText(applicationContext, "Error !",Toast.LENGTH_SHORT).show()

                }, ){
                    override fun getParams(): MutableMap<String, String> {
                        val parameters: MutableMap<String, String> = HashMap();
                        parameters["name"]=edit_name.text.toString()
                        parameters["description"]=edit_desc.text.toString()
                        if(check_fav.isChecked){
                            parameters["favorito"]="1"
                        }else{
                            parameters["favorito"]="0"
                        }

                        if(check_show.isChecked){
                            parameters["show"]="1"
                        }else{
                            parameters["show"]="0"
                        }


                        if(check_prod.isChecked){
                            parameters["production"]="1"
                        }else{
                            parameters["production"]="0"
                        }
                        return parameters
                    }
                }
                request.add(r)
            }else{
                Toast.makeText(applicationContext, "Tens de preencher !",Toast.LENGTH_SHORT).show()
            }
        }

    }
}