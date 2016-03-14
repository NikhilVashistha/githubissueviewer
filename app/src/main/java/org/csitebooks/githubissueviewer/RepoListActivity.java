package org.csitebooks.githubissueviewer;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

import org.csitebooks.app.DeviceUtils;
import org.csitebooks.model.Repo;
import org.csitebooks.retrofit.RetrofitApi;
import org.csitebooks.retrofit.ServiceGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class RepoListActivity extends AppCompatActivity {

   private ListView RepoIssueList ;
    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repo_list);

        String[] pathAfterSplit = getIntent().getStringExtra("path").split("/");

        String repoUser = pathAfterSplit[pathAfterSplit.length-2];
        String repoName = pathAfterSplit[pathAfterSplit.length-1];



        setTitle(repoName);

        RepoIssueList = (ListView) findViewById(R.id.repoList);
        pDialog = new ProgressDialog(this);

        // Set progressbar message
        pDialog.setMessage("Getting List...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);


        ArrayAdapter arrayAdapter =
                new ArrayAdapter(this,
                        android.R.layout.simple_list_item_1,
                        android.R.id.text1,
                        new ArrayList<Repo>());
        RepoIssueList.setAdapter(arrayAdapter);

        if(DeviceUtils.checkNetworkState( RepoListActivity.this )){
            getListData(repoUser , repoName);

            // Show progressbar
            pDialog.show();

        }else {
            DeviceUtils.showToast(RepoListActivity.this , "No Internet Connection");
        }

    }


    /**
     * method is used for getting issue list from github
     *
     * @param repoUser , repoName string
     *
     */
    private void getListData(String repoUser, String repoName){

        RetrofitApi retrofitApi = ServiceGenerator.createService(RetrofitApi.class);

        retrofitApi.loadIssueList(repoUser ,repoName , new Callback<List<Repo>>() {
            @Override
            public void success(List<Repo> repos, Response response) {

                ArrayAdapter adapter = (ArrayAdapter) RepoIssueList.getAdapter();
                adapter.clear();

                ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();

                HashMap<String, String> map ;
                for (Repo contributor : repos) {
                    map = new HashMap<String, String>();

                    map.put("title" ,  contributor.getTitle());
                    map.put("date" , contributor.getUpdatedAt());

                    mylist.add(map);

                }

                Collections.sort(mylist, new Comparator<HashMap<String, String>>() {
                    @Override
                    public int compare(HashMap<String, String> lhs, HashMap<String, String> rhs) {

                        return rhs.get("date").compareTo(lhs.get("date"));

                    }
                });

                if(!mylist.isEmpty()){

                    pDialog.dismiss();

                    for(int k = 0; k < mylist.size(); k++){
                        adapter.add(mylist.get(k).get("title"));
                    }

                }

            }

            @Override
            public void failure(RetrofitError error) {

                pDialog.dismiss();
                DeviceUtils.showToast(RepoListActivity.this , "Try Again");
                error.printStackTrace();

            }
        });
    }

}
