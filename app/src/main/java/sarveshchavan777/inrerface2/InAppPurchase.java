package sarveshchavan777.inrerface2;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.vending.billing.IInAppBillingService;

import java.util.List;

import info.hoang8f.widget.FButton;
import util.IabBroadcastReceiver;
import util.IabHelper;
import util.IabResult;
import util.Inventory;
import util.Purchase;

public class InAppPurchase extends Activity implements IabBroadcastReceiver.IabBroadcastListener {
    IInAppBillingService mService;

    static final String SKU_Gems = "4637086852927740462";

    static final String TAG = "Trivia Knowledge";

    DemoHelperClass demoHelperClass;

    Context context;

    // (arbitrary) request code for the purchase flow
    static final int RC_REQUEST = 10001;

    // The helper object
    IabHelper mHelper;

    // Provides purchase notification while this app is running
    IabBroadcastReceiver mBroadcastReceiver;

   /* public InAppPurchase(Context context) {
        super();
        this.context = context;
    }*/

    //variables of java activity
    FButton fButton;
    TextView shopGemsText;
    TextView shopText;
    ImageView leftShop;
    Integer value;

    MediaPlayer mediaPlayer;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.in_app_purchase);
        demoHelperClass = new DemoHelperClass(getApplicationContext());
        value = getIntent().getIntExtra("key", 0);
        //declaring java activity
        fButton = (FButton) findViewById(R.id.shop1);
        fButton.setEnabled(false);
        shopGemsText = (TextView) findViewById(R.id.shopGemsText);
        shopText = (TextView) findViewById(R.id.shopText);
        leftShop = (ImageView) findViewById(R.id.leftShop);
        final Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/shablagooital.ttf");
        fButton.setTypeface(typeface);
        shopGemsText.setTypeface(typeface);
        shopText.setTypeface(typeface);
        leftShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              /*if(value!=20000){
                  Intent intent = new Intent(getApplicationContext(), Personality.class);
                  intent.putExtra("Key", String.valueOf(value));
                  startActivity(intent);
                  finish();
              }
              if(value==20000){*/
                finish();
//              }

            }
        });


        String base64EncodedPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAnCackcCmTlGn8KRrFFieHjaKqVYA09FfKr3VTpf5SqYZEDdX3ohZRpPSh3+ldZPcSZ5ZVHFhsda720ykXoCqCU7f93CC0IhQXWQ+IBtLXM4POLJr5kCzoG7rCSrzFMa/RekXVKBfQ3mf4waRDy8trVLEeiUhYpfxrZvQ2Bl51V7doVwJnZZo6SM4KUv+ZXVrY/7o1ZSQ4PdH++DW81XRV73oJzVt/dY0gNqX3TgpAGVeYyvwTXOOunMq6LenqeyCpkSeqIO3oWKMzWFw94UuwLqikFXtWCvqkYpS/VzAbalkRssBrMFCA/2d3Qm7d8r8K2iJwHbTG6HtQPaTIfOQAwIDAQAB";

        // Create the helper, passing it our context and the public key to verify signatures with
        Log.d(TAG, "Creating IAB helper.");
        mHelper = new IabHelper(this, base64EncodedPublicKey);


        // enable debug logging (for a production application, you should set this to false).
        mHelper.enableDebugLogging(false);


        // Start setup. This is asynchronous and the specified listener
        // will be called once setup completes.
        Log.d(TAG, "Starting setup.");
        mHelper.startSetup(new IabHelper.OnIabSetupFinishedListener() {
            public void onIabSetupFinished(IabResult result) {
                Log.d(TAG, "Setup finished.");

                if (!result.isSuccess()) {
                    // Oh noes, there was a problem.
                    complain("Problem setting up in-app billing: " + result);
                    Toast.makeText(InAppPurchase.this, "There was a Problem setting up in-app billing try again later", Toast.LENGTH_LONG).show();
                    return;
                } else {
                    fButton.setEnabled(true);
                }

                // Have we been disposed of in the meantime? If so, quit.
                if (mHelper == null) return;

                // Important: Dynamically register for broadcast messages about updated purchases.
                // We register the receiver here instead of as a <receiver> in the Manifest
                // because we always call getPurchases() at startup, so therefore we can ignore
                // any broadcasts sent while the app isn't running.
                // Note: registering this listener in an Activity is a bad idea, but is done here
                // because this is a SAMPLE. Regardless, the receiver must be registered after
                // IabHelper is setup, but before first call to getPurchases().
                mBroadcastReceiver = new IabBroadcastReceiver(InAppPurchase.this);
                IntentFilter broadcastFilter = new IntentFilter(IabBroadcastReceiver.ACTION);
                registerReceiver(mBroadcastReceiver, broadcastFilter);

                // IAB is fully set up. Now, let's get an inventory of stuff we own.
                Log.d(TAG, "Setup successful. Querying inventory.");
                try {
                    mHelper.queryInventoryAsync(mGotInventoryListener);
                } catch (IabHelper.IabAsyncInProgressException e) {
                    complain("Error querying inventory. Another async operation in progress.");
                }
            }
        });

    }

    // Listener that's called when we finish querying the items and subscriptions we own
    IabHelper.QueryInventoryFinishedListener mGotInventoryListener = new IabHelper.QueryInventoryFinishedListener() {
        @Override

        public void onQueryInventoryFinished(IabResult result, Inventory inventory) {
            Log.d(TAG, "Query inventory finished.");

            // Have we been disposed of in the meantime? If so, quit.
            if (mHelper == null) return;

            // Is it a failure?
            if (result.isFailure()) {
                complain("Failed to query inventory: " + result);
                return;
            }

            Log.d(TAG, "Query inventory was successful.");

            /*
             * Check for items we own. Notice that for each purchase, we check
             * the developer payload to see if it's correct! See
             * verifyDeveloperPayload().
             */


            // Check for gas delivery -- if we own gas, we should fill up the tank immediately
            Purchase gasPurchase = inventory.getPurchase(SKU_Gems);
            if (gasPurchase != null && verifyDeveloperPayload(gasPurchase)) {
                Log.d(TAG, "We have Gems. Consuming it.");
                try {
                    mHelper.consumeAsync(inventory.getPurchase(SKU_Gems), mConsumeFinishedListener);
                } catch (IabHelper.IabAsyncInProgressException e) {
                    complain("Error consuming Gems. Another async operation in progress.");
                }
                return;
            }

            Log.d(TAG, "Initial inventory query finished; enabling main UI.");
        }
    };

    @Override
    public void receivedBroadcast() {
        // Received a broadcast notification that the inventory of items has changed
        Log.d(TAG, "Received broadcast notification. Querying inventory.");
        try {
            mHelper.queryInventoryAsync(mGotInventoryListener);
        } catch (IabHelper.IabAsyncInProgressException e) {
            complain("Error querying inventory. Another async operation in progress.");

        }
    }

    public void buyGems(View v) {
        /* TODO: for security, generate your payload here for verification. See the comments on
         *        verifyDeveloperPayload() for more info. Since this is a SAMPLE, we just use
         *        an empty string, but on a production app you should carefully generate this. */
        String payload = "";

        if (checkSound()) {
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.gameaudio2);
            if (mediaPlayer != null) {
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        mediaPlayer.reset();
                        mediaPlayer.release();
                    }
                });
            }
        }

        try {
            mHelper.launchPurchaseFlow(this, SKU_Gems, RC_REQUEST,
                    mPurchaseFinishedListener, payload);
        } catch (IabHelper.IabAsyncInProgressException e) {
            complain("Error launching purchase flow. Another async operation in progress.");
        }


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d(TAG, "onActivityResult(" + requestCode + "," + resultCode + "," + data);
        if (mHelper == null) return;

        // Pass on the activity result to the helper for handling
        if (!mHelper.handleActivityResult(requestCode, resultCode, data)) {
            // not handled, so handle it ourselves (here's where you'd
            // perform any handling of activity results not related to in-app
            // billing...
            super.onActivityResult(requestCode, resultCode, data);
        } else {
            Log.d(TAG, "onActivityResult handled by IABUtil.");
        }
    }

    boolean verifyDeveloperPayload(Purchase p) {
        String payload = p.getDeveloperPayload();

        /*
         * TODO: verify that the developer payload of the purchase is correct. It will be
         * the same one that you sent when initiating the purchase.
         *
         * WARNING: Locally generating a random string when starting a purchase and
         * verifying it here might seem like a good approach, but this will fail in the
         * case where the user purchases an item on one device and then uses your app on
         * a different device, because on the other device you will not have access to the
         * random string you originally generated.
         *
         * So a good developer payload has these characteristics:
         *
         * 1. If two different users purchase an item, the payload is different between them,
         *    so that one user's purchase can't be replayed to another user.
         *
         * 2. The payload must be such that you can verify it even when the app wasn't the
         *    one who initiated the purchase flow (so that items purchased by the user on
         *    one device work on other devices owned by the user).
         *
         * Using your own server to store and verify developer payloads across app
         * installations is recommended.
         */

        return true;
    }

    // Callback for when a purchase is finished
    IabHelper.OnIabPurchaseFinishedListener mPurchaseFinishedListener = new IabHelper.OnIabPurchaseFinishedListener() {
        public void onIabPurchaseFinished(IabResult result, Purchase purchase) {
            Log.d(TAG, "Purchase finished: " + result + ", purchase: " + purchase);

            // if we were disposed of in the meantime, quit.
            if (mHelper == null) return;

            if (result.isFailure()) {
                //   complain("Error purchasing: " + result);

                return;
            }
            if (!verifyDeveloperPayload(purchase)) {
                complain("Error purchasing. Authenticity verification failed.");

                return;
            }

            Log.d(TAG, "Purchase successful.");


            if (purchase.getSku().equals(SKU_Gems)) {
                leftShop.setEnabled(false);
                // bought gems tank of gas. So consume it.
                Toast.makeText(getApplicationContext(), "Please wait on this page..Starting gems consumption.", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "Purchase is gems. Starting gems consumption.");
                try {
                    mHelper.consumeAsync(purchase, mConsumeFinishedListener);
                } catch (IabHelper.IabAsyncInProgressException e) {
                    complain("Error consuming Gems Another async operation in progress.");

                }
            }
        }
    };

    // Called when consumption is complete
    IabHelper.OnConsumeFinishedListener mConsumeFinishedListener = new IabHelper.OnConsumeFinishedListener() {
        public void onConsumeFinished(Purchase purchase, IabResult result) {
            Log.d(TAG, "Consumption finished. Purchase: " + purchase + ", result: " + result);

            // if we were disposed of in the meantime, quit.
            if (mHelper == null) return;

            // We know this is the "gas" sku because it's the only one we consume,
            // so we don't check which sku was consumed. If you have more than one
            // sku, you probably should check...
            if (result.isSuccess()) {
                // successfully consumed, so we apply the effects of the item in our
                // game world's logic, which in our case means filling the gas tank a bit
                Log.d(TAG, "Consumption successful. Provisioning.");
                //someSqlite stuff
                demoHelperClass = new DemoHelperClass(getApplicationContext());
                List listgems = demoHelperClass.getGems();
                int gems = (Integer) listgems.get(listgems.size() - 1);
                int totalGems = 30 + gems;
                demoHelperClass.InsertGems(totalGems);

                alert("30 more Gems added in your bucket");
                final Typeface typeface2 = Typeface.createFromAsset(getAssets(), "fonts/OpenSans-Semibold.ttf");

                Toast toast = Toast.makeText(getApplicationContext(), "30 more Gems added in your bucket ", Toast.LENGTH_LONG);
                toast.getView().setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.darkpink));
                TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                v.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
                v.setTypeface(typeface2);
                v.setTextSize(10);
                toast.show();
                listgems.clear();
            } else {
                complain("Error while consuming: " + result);
            }

            Log.d(TAG, "End consumption flow.");

            leftShop.setEnabled(true);
        }
    };

    // We're being destroyed. It's important to dispose of the helper here!
    @Override
    public void onDestroy() {
        super.onDestroy();

        // very important:
        if (mBroadcastReceiver != null) {
            unregisterReceiver(mBroadcastReceiver);
        }

        // very important:
        Log.d(TAG, "Destroying helper.");
        if (mHelper != null) {
            mHelper.disposeWhenFinished();
            mHelper = null;
        }

        leftShop.setOnClickListener(null);
    }

    void complain(String message) {
        Log.e(TAG, "**** Trivia Knowledge Error: " + message);
        alert("Error: " + message);
    }

    void alert(String message) {
        AlertDialog.Builder bld = new AlertDialog.Builder(this);
        bld.setMessage(message);
        bld.setNeutralButton("OK", null);
        Log.d(TAG, "Showing alert dialog: " + message);
        bld.create().show();
    }

    /*public void buyed(View view) {
        DemoHelperClass demoHelperClass=new DemoHelperClass(InAppPurchase.this);
        List listgems=demoHelperClass.getGems();
        int gems = (Integer) listgems.get(listgems.size() - 1);
        int totalGems=30+gems;
        demoHelperClass.InsertGems(30+gems);
        Personality.diamondtext.setText(Integer.toString(totalGems));
    }*/

    @Override
    public void onBackPressed() {
       /* if(value!=20000){
            Intent intent = new Intent(getApplicationContext(), Personality.class);
            intent.putExtra("Key", String.valueOf(value));
            startActivity(intent);
            finish();
        }
        if(value==20000){*/
        if (leftShop.isEnabled()) {
            finish();
        } else {
            Toast.makeText(getApplicationContext(), "Please wait", Toast.LENGTH_SHORT).show();
        }

      /*  }*/
    }

    public Boolean checkSound() {

        List list = demoHelperClass.getSound();
        if (list != null) {
            if (list.size() % 2 == 0) {
                //  Toast.makeText(getActivity(),"true",Toast.LENGTH_LONG).show();
                return true;
            }
        }
        return false;
    }

}
