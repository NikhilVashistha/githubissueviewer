# GitHub Issue Viewer
Created an app to display the list of issues from a github repository. This app :

* Uses github web api to retrieve all open issues associated with the repository

* Take input for the repository link. Sample link : https://github.com/pardom/ActiveAndroid

![Enter GitHub Repo Url](/input_url.png?raw=true "GitHub Issue Viewer")

* Display a list of open issues to the user.
 - Screen title : Repo name
 - Ordered by most recently updated issues first.
 - Issue title (max 2 lines) shown in the list.
  
![GitHub Repo List](/issues_list.png?raw=true "GitHub Issue Viewer")

● Documentation for the github issues API can be found here:
https://developer.github.com/v3/issues/

● Sample API link to fetch issues for a repo :
https://api.github.com/repos/pardom/ActiveAndroid/issues
