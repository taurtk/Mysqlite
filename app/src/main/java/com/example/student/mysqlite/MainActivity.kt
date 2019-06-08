package com.example.student.mysqlite

import android.content.Context
import android.database.Cursor
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val database=openOrCreateDatabase("student",Context.MODE_PRIVATE,null)
        database.execSQL("create table if not exists student (id number,name varchar,marks number);")

        database.rawQuery("insert into student values(1,'uddin',100);",null)
        database.rawQuery("insert into student values(2,'piyush',70);",null)
        database.rawQuery("insert into student values(3,'monu',80);",null)
        database.rawQuery("insert into student values(4,'jeevan',500);",null)
        database.rawQuery("insert into student values(5,'jaiswal',300);",null)
        database.rawQuery("insert into student values(6,'abinav',80);",null)

        val cursor:Cursor=database.rawQuery("select * from student;",null) as Cursor

        Toast.makeText(this,"col count :"+cursor.columnCount,Toast.LENGTH_LONG).show()
        Toast.makeText(this,"row count :"+cursor.count,Toast.LENGTH_LONG).show()
        Toast.makeText(this,"col name :"+cursor.getColumnName(1),Toast.LENGTH_LONG).show()
        Toast.makeText(this,"col index :"+cursor.getColumnIndex("name"),Toast.LENGTH_LONG).show()
        Toast.makeText(this,"col name at index 1 :"+cursor.columnNames[1],Toast.LENGTH_LONG).show()




    }
}
