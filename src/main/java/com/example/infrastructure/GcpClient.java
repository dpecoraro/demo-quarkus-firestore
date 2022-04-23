package com.example.infrastructure;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import javax.inject.Singleton;
import java.io.IOException;

@Singleton
public class GcpClient {
    public GcpClient() throws IOException {
        try {
            GoogleCredentials credentials = GoogleCredentials.getApplicationDefault();

            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(credentials)
                    .setProjectId("polished-coil-347403")
                    .build();
            FirebaseApp.initializeApp(options);
            this.dataBase = FirestoreClient.getFirestore();
        } catch(IOException ex){
            ex.printStackTrace();
        }
    }
    private Firestore dataBase;

    public Firestore GetDataBase() {return this.dataBase;}

}
