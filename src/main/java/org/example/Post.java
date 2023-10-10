package org.example;

import java.util.Objects;

public class Post {
    /*
    {
    "postId": 10,
    "id": 46,
    "name": "dignissimos et deleniti voluptate et quod",
    "email": "Jeremy.Harann@waino.me",
    "body": "exercitationem et id quae cum omnis\nvoluptatibus accusantium et quidem\nut ipsam sint\ndoloremque illo ex atque necessitatibus sed"
  },
 */
    private int postId;
    private int id;
    private String name;
    private String email;
    private String body;


    public int getId() {
        return id;
    }
    public String getBody() {
        return body;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setBody(String body) {
        this.body = body;
    }
    public int getPostId() {
        return postId;
    }
    public void setPostId(int postId) {
        this.postId = postId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", body='" + body + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if(o==null || getClass() !=o.getClass())return false;
        Post post =(Post) o;
        return id == post.id &&
                Objects.equals(postId, post.postId) &&
                Objects.equals(name, post.name);
    }
    @Override
    public int hashCode(){
        return Objects.hash(id, postId, name);
    }

}
