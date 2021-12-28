package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.Source;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "final";
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    Button firstBtn;
    Button secondBtn;
    Button thirdBtn;


    EditText editText;

    public class User {

        public String Q1;
        public String Q2;
        public  String Q3;

        public User() {
            // Default constructor required for calls to DataSnapshot.getValue(User.class)
        }

        public String User1(String a, String b, String c) {
            return a+""+b+""+c;
        }


        public String User(String username, String email, String third) {
            this.Q1 = Q1;
            this.Q2 = Q2;
            this.Q3 = Q3;
            return Q1+""+Q2+""+Q3;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstBtn = findViewById(R.id.firstBtn);
        secondBtn = findViewById(R.id.secondBtn);
        thirdBtn = findViewById(R.id.thirdBtn);

        editText = findViewById(R.id.exampletextEdit);


        Map<String, Object> user = new HashMap<>();

        db.collection("users")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });

        db.collection("users")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());
                            }
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });


        firstBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                AlertDialog.Builder bui1 = new AlertDialog.Builder(MainActivity.this);
//                bui1.setMessage("Ответ неверный");
//                bui1.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        dialogInterface.cancel();
//                    }
//                });
//                AlertDialog alei = bui1.create();
//                alei.show();
                editText.append((String) user.get("first"));


            }
        });





















//        secondBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                AlertDialog.Builder bui2 = new AlertDialog.Builder(MainActivity.this);
//                bui2.setMessage("Молодец");
//                bui2.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
//                        startActivity(intent);
//                        MainActivity.this.finish();
//
//                    }
//                });
//                AlertDialog alei2 = bui2.show();
//                alei2.show();
//            }
//        });





    }

}