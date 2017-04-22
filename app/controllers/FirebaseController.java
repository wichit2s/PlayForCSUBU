package controllers;

import play.mvc.*;
import play.Logger; 
import play.libs.Json;

// firebase
import com.google.firebase.*;
import com.google.firebase.auth.*;
import com.google.firebase.database.*;
import com.google.firebase.tasks.*;

// form
import javax.inject.*;
import play.data.*;

import java.util.*;
import models.*;
import services.*;

import play.db.ebean.Transactional;

import views.html.*;


/**
 * ตัวอย่าง controller ที่ใช้งานร่วมกับ firebase.
 *
 * ขั้นตอนในการใช้งาน Play framework ร่วมกับ firebase มีดังนี้
 *
 */
@Singleton
public class FirebaseController extends Controller implements ValueEventListener {

  static final Logger.ALogger logger = Logger.of(EbeanController.class);

  //@Inject
  //FirebaseAppSingleton app;

  @Inject
  FormFactory formFactory;

  @Override
  public void onDataChange(DataSnapshot dataSnapshot) {
    Logger.warn("onDataChange(): ");
    Object document = dataSnapshot.getValue();
    Logger.warn("{}", document);
  }

  @Override
  public void onCancelled(DatabaseError error) {
    Logger.warn("onCancelled(): {}", error);
  }

  public Result index() {
    FirebaseAuth defaultAuth = FirebaseAuth.getInstance();
    FirebaseDatabase defaultDatabase = FirebaseDatabase.getInstance();
    Logger.warn("[defaultAuth]: %n{}", defaultAuth);
    Logger.warn("[defaultDatabase]: %n{}", defaultDatabase);
    DatabaseReference ref = defaultDatabase.getReference("playdb");
    ref.addListenerForSingleValueEvent(this);
    return ok(firebase.render());
  }

  public Result nojs() {
    FirebaseAuth defaultAuth = FirebaseAuth.getInstance();
    FirebaseDatabase defaultDatabase = FirebaseDatabase.getInstance();
    Logger.warn("[nojs]: %n{}", defaultDatabase);
    DatabaseReference ref = defaultDatabase.getReference("playdb");
    ref.addListenerForSingleValueEvent(this);
    return ok(csubu.render());
  }

}
