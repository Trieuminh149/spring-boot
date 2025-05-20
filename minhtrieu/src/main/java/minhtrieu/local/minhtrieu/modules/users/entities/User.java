package minhtrieu.local.minhtrieu.modules.users.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Column;
import java.time.LocalDateTime;


import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
@Entity
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="user_catalogue_id")
    private Long user_catalogue_Id;

    private String name;
    private String email;
    private String password;
    private String phone;
    private String image;
    private String address;

    @Column(name="created_at")
    private LocalDateTime createdAt;

    @Column(name="updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreated(){
        createdAt=LocalDateTime.now();
    }
    
    @PreUpdate
    protected void onUpdated() {
        updatedAt = LocalDateTime.now();

    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }
    public Long getUser_Catalogue_Id(){
        return user_catalogue_Id;
    }
    public void setUser_Catalogu_eId(Long user_catalogue_Id){
        this.user_catalogue_Id = user_catalogue_Id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public  String getphone(){
        return phone;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public String getimage(){
        return image;
    }
    public void setImage(String image){
        this.image = image;
    }

     public String getaddress(){
        return address;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public LocalDateTime getCreatedAt(){
        return createdAt;
    }

    public LocalDateTime getUpdatedAt(){
        return updatedAt;
    }
}
