package com.mall.repositories.register;

import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.mall.model.UserModel;

import java.util.Objects;

public class RegisterRepository
{

    private FirebaseAuth firebaseAuth;
    private DatabaseReference userReference;
    private MutableLiveData<String> stringMutableLiveData;
    private MutableLiveData<Boolean> booleanMutableLiveData;
    private StorageReference imageUserRef;

    public RegisterRepository()
    {
        firebaseAuth = FirebaseAuth.getInstance();
        userReference = FirebaseDatabase.getInstance().getReference();
        stringMutableLiveData = new MutableLiveData<>();
        booleanMutableLiveData = new MutableLiveData<>();
        imageUserRef = FirebaseStorage.getInstance().getReference().child("Images").child("Users'_Image").child(Objects.requireNonNull(userReference.push().getKey()));
    }


    public MutableLiveData<Boolean> createAccount(String image, String mail, String name, String password)
    {
        firebaseAuth
                .createUserWithEmailAndPassword(mail, password)
                .addOnSuccessListener(new OnSuccessListener<AuthResult>()
                {
                    @Override
                    public void onSuccess(AuthResult authResult)
                    {
                        imageUserRef
                                .putFile(Uri.parse(image))
                                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>()
                                {
                                    @Override
                                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot)
                                    {
                                        imageUserRef
                                                .getDownloadUrl()
                                                .addOnSuccessListener(new OnSuccessListener<Uri>()
                                                {
                                                    @Override
                                                    public void onSuccess(Uri uri)
                                                    {
                                                        booleanMutableLiveData.postValue(true);
                                                        String userID = firebaseAuth.getCurrentUser().getUid();
                                                        UserModel userModel = new UserModel(uri.toString(), mail, name);
                                                        userReference.child("Users").child(userID).setValue(userModel);
                                                    }
                                                }).addOnFailureListener(new OnFailureListener()
                                        {
                                            @Override
                                            public void onFailure(@NonNull Exception e)
                                            {
                                                stringMutableLiveData.setValue(e.getMessage());
                                            }
                                        });
                                    }
                                }).addOnFailureListener(new OnFailureListener()
                        {
                            @Override
                            public void onFailure(@NonNull Exception e)
                            {
                                stringMutableLiveData.setValue(e.getMessage());
                            }
                        });
                    }
                }).addOnFailureListener(new OnFailureListener()
        {
            @Override
            public void onFailure(@NonNull Exception e)
            {
                stringMutableLiveData.setValue(e.getMessage());
            }
        });
        return booleanMutableLiveData;
    }
}
