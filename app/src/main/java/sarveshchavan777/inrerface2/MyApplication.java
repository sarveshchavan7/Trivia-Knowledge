package sarveshchavan777.inrerface2;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;
import android.util.Log;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        printKeyHash();
    }
 public void printKeyHash(){
     // Add code to print out the key hash
     try {
         PackageInfo info = getPackageManager().getPackageInfo(
                 "sarveshchavan777.inrerface2",
                 PackageManager.GET_SIGNATURES);
         for (Signature signature : info.signatures) {
             MessageDigest md = MessageDigest.getInstance("SHA");
             md.update(signature.toByteArray());
             Log.d("sarvesj keyhash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
         }
     } catch (PackageManager.NameNotFoundException e) {

     } catch (NoSuchAlgorithmException e) {

     }
 }

}
