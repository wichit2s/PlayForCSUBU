package models;

import java.util.*;
import javax.persistence.*;

import com.avaje.ebean.Model;
import play.data.format.*;
import play.data.validation.*;

@Entity
public class Todo extends Model {

  @Id
  public UUID id = UUID.randomUUID();

  @Constraints.Required
  public String text;

  public boolean done;

  @Formats.DateTime(pattern="dd/MM/yyyy")
  public Date createdDate = new Date();

  public static Model.Finder<UUID, Todo> find = new Model.Finder<UUID, Todo>(Todo.class);
}
