package org.example;

import java.util.Objects;
public class Todos {
    /*  {
          "userId": 1,
              "id": 1,
              "title": "delectus aut autem",
              "completed": false
      },
  */
    private int userId ;
    private int id;
    private String title;
    private boolean completed;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "Todos{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }
    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if(o==null || getClass() !=o.getClass())return false;
        Todos todos =(Todos) o;
        return id == todos.id &&
                Objects.equals(userId, todos.userId) &&
                Objects.equals(title, todos.title);
    }
    @Override
    public int hashCode(){
        return Objects.hash(id, userId, title);
    }
}

