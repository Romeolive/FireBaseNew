package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class LevelOne extends AppCompatActivity {

    TextView levelOneQuestion;
    Button levelOneAnswerOne;
    Button levelOneAnswerTwo;
    Button levelOneAnswerThree;
    Button levelOneAnswerFour;

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    DocumentReference docRef = db.collection("questionFirstLevel").document("questionFirstLevel");
    private static final String TAG = "USER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_one);

        levelOneQuestion = findViewById(R.id.levelOneQuestion);
        levelOneAnswerOne = findViewById(R.id.levelOneAnswerOne);
        levelOneAnswerTwo = findViewById(R.id.levelOneAnswerTwo);
        levelOneAnswerThree = findViewById(R.id.levelOneAnswerThree);
        levelOneAnswerFour = findViewById(R.id.levelOneAnswerFour);

        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {

            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                        levelOneQuestion.setText(document.getData().get("questionFirstLevel").toString());

                        levelOneAnswerOne.setText(document.getData().get("answerFirstLevelOne").toString());
                        levelOneAnswerTwo.setText(document.getData().get("answerFirstLevelTwo").toString());
                        levelOneAnswerThree.setText(document.getData().get("answerFirstLevelThree").toString());
                        levelOneAnswerFour.setText(document.getData().get("answerFirstLevelFour").toString());
                    } else {
                        Log.d(TAG, "No such document");
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });


        levelOneAnswerOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(LevelOne.this);
                builder1.setMessage("Ответ неверный");
                builder1.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                AlertDialog alertDialog = builder1.create();
                alertDialog.show();

            }
        });
        levelOneAnswerTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(LevelOne.this);
                builder1.setMessage("Ответ неверный");
                builder1.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                AlertDialog alertDialog = builder1.create();
                alertDialog.show();

            }
        });
        levelOneAnswerThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(LevelOne.this);
                builder1.setMessage("Ответ неверный");
                builder1.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                AlertDialog alertDialog = builder1.create();
                alertDialog.show();

            }
        });

        levelOneAnswerFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(LevelOne.this);
                builder1.setMessage("Верно!!!");
                builder1.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(LevelOne.this,MainActivity.class);
                        startActivity(intent);
                        LevelOne.this.finish();

                    }
                });
                AlertDialog alertDialog = builder1.create();
                alertDialog.show();

            }
        });





    }
}