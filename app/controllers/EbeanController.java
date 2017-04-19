package controllers;

import play.mvc.*;
import play.Logger; 

// form
import javax.inject.*;
import play.data.*;

import java.util.*;
import models.*;

import play.db.ebean.Transactional;

import views.html.*;


/**
 * ตัวอย่าง controller เพื่อแสดงวิธีการใช้ Ebean เพื่อจัดเก็บข้อมูลของระบบ.
 *
 * Ebean เป็น technology Object-Relation Mapper เพื่อช่วยให้เราสามารถเขียนคลาสในภาษาจาวาแล้วสร้างคำสั่ง SQL เพื่อเรียกใช้งาน DBMS โดยอัตโนมัติ.
 *
 * ขั้นตอนในการใช้ Ebean มีดังนี้
 * 1. เปิดไฟล์ project/plugins.sbt เพิ่มคำสั่งต่อไปนี้
 * addSbtPlugin("com.typesafe.sbt" % "sbt-play-ebean" % "3.0.0")
 *
 * 2. เปิดการใช้งาน Ebean ในไฟล์ build.sbt ดังนี้
 * .enablePlugins(PlayJava, PlayEbean)
 *
 * 3. ระบุชื่อ package ของคลาสที่จะใช้ map โดยการเปิดไฟล์ conf/appliction.conf แล้วกรอก
 * ebean.default = ["models.*"]
 * 
 * 4. ระบุฐานข้อมูลที่จะใช้ DBMS  
 * db {
 *  default.driver = org.h2.Driver
 *  default.url = "jdbc:h2:mem:play"
 *  default.username = sa
 *  default.password = ""
 *  }
 *
 * 5. สร้างคลาสที่จะใช้เป็น Ebean model
 * app/models/Todo.java
 *
 * 6. การเรียกใช้
 * import play.db.ebean.Transactional;
 * @Transactional
 * public Result done(long id) {
 *     Todo todo = Todo.find.byId(34L);
 *     todo.done = true;
 *     todo.save();
 *     return ok();
 * }
 * หรือ
 * i. ค้นหาทุก Todo
 * <pre>
 * List<Todo> todos = Todo.find.all();
 * </pre>
 * ii. ค้นหา Todo โดยใช้ id
 * <pre>
 *  Todo t = Todo.find.byId(34L);
 *  Delete a task by ID
 *  Todo.find.ref(34L).delete();
 * </pre>
 * iii. ค้นหา Todo ที่มีคำว่า java
 * <pre>
 *  List<Todo> javaTodoList = Todo.find.where()
 *                            .ilike("text", "%java%")
 *                            .orderBy("createdDate asc")
 *                            .findPagedList(1, 25)
 *                            .getList();
 * </pre>
 */
public class EbeanController extends Controller {

  static final Logger.ALogger logger = Logger.of(EbeanController.class);

    @Inject
    FormFactory formFactory;

    @Transactional
    public Result create(String text) {
      Todo t = new Todo();
      //t.id = UUID.randomUUID();
      t.text = text;
      //t.createdDate = new java.util.Date();
      //t.done = false;
      t.save();
      return ok(String.format("Todo(%s, \"%s\") created", t.id, t.text));
    }

    @Transactional
    public Result createFromForm() {
      DynamicForm form = formFactory.form().bindFromRequest();
      Todo t = new Todo();
      //t.id = UUID.randomUUID();
      t.text = form.get("text");
      //t.createdDate = new java.util.Date();
      //t.done = false;
      t.save();
      return redirect("/");
    }

    @Transactional
    public Result deleteTodo(UUID id) {
      Todo.find.ref(id).delete();
      return redirect("/");
    }

}
