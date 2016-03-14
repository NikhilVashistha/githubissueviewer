package org.csitebooks.retrofit;

/**
 * Created by abc on 01-12-2015.
 */

import org.csitebooks.model.Repo;

import java.util.List;


import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

public interface RetrofitApi {


	@GET("/repos/{repoUser}/{repoName}/issues")
	void loadIssueList(@Path("repoUser") String repoUser ,@Path("repoName") String repoName  , Callback<List<Repo>> repolist);
}
