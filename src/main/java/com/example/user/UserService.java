package com.example.user;

import com.example.infrastructure.GcpClient;
import com.example.user.dto.UserDTO;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Singleton
public class UserService {

    @Inject
    private GcpClient gcpClient;

    private List<UserDTO> users = new ArrayList<UserDTO>();
    
    public boolean Add(UserDTO user) {
        try {
            Firestore database = gcpClient.GetDataBase();
            var docRef = database.collection("users")
                    .document(UUID.randomUUID().toString());
            docRef.set(user);
        } catch(Exception ex){
            return false;
        }
        return true;
    }

    public List<UserDTO> GetAll(){
        try {
            Firestore db = gcpClient.GetDataBase();

            ApiFuture<QuerySnapshot> query = db.collection("users").get();
            QuerySnapshot snapShot = query.get();
            List<QueryDocumentSnapshot> documents = snapShot.getDocuments();

            documents.forEach(document -> {
                UserDTO user = document.toObject(UserDTO.class);
                this.users.add(user);
            });

            return this.users;
        } catch(Exception ex) {
            return null;
        }
    }
}
