package org.csitebooks.githubissueviewer;

/**
 * Created by abc on 01-12-2015.
 */

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.csitebooks.app.DeviceUtils;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private Button submit;
    private EditText url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DeviceUtils.hideKeyboard( MainActivity.this );

                if(isGithubUrl(url.getText().toString())) {

                    goToListActivity(getRepoPath(url.getText().toString()));

                }else {
                    DeviceUtils.showToast( MainActivity.this , "Enter a valid github repo url");
                }
            }
        });

    }

    /**
     * method is used for finding Views by ID.
     */
    private void findViews(){
        url = (EditText)findViewById(R.id.etUrl);

        submit = (Button) findViewById(R.id.btnSubmit);
    }

    /**
     * method is used for getting repo name from github url.
     *
     * @param gitHubUrl string to be used to get repo name
     * @return String repo name
     */
    private String getRepoPath(String gitHubUrl){

        Uri uri = Uri.parse(gitHubUrl);

        String path = uri.getPath();

        Log.d("Repo path : ",  path);

        return path;
    }


    /**
     * method is used for checking valid github url format.
     *
     * @param url string to be validated as github url
     * @return boolean true for valid false for invalid
     */
    private Boolean isGithubUrl(String url){

        String gitHubRepoRejex = "^https?:\\/\\/(www.)?github\\.com\\/[a-zA-Z0-9]+\\/[a-zA-Z0-9]+";

        try {
            Pattern patt = Pattern.compile(gitHubRepoRejex);
            Matcher matcher = patt.matcher(url);
            return matcher.matches();
        } catch (RuntimeException e) {
            return false;
        }
    }


    /**
     * method is used to navigate on list activity.
     *
     * @param path string and repoName string
     */
    private void goToListActivity(String path){
        Intent intent = new Intent(MainActivity.this , RepoListActivity.class);
        intent.putExtra("path" ,  path);
        startActivity(intent);
    }

}
