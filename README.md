# githubissueviewer
Created an app to display the list of issues from a github repository. This app :

1. Uses github web api to retrieve all open issues associated with the repository

2. Take input for the repository link. Sample link : https://github.com/pardom/ActiveAndroid

![Enter GitHub Repo Url](/input_url.png?raw=true "GitHub Issue Viewer")

 Display a list of open issues to the user.
  a. Screen title : Repo name
  b. Ordered by most recently updated issues first.
  c. Issue title (max 2 lines) shown in the list.
  
![Enter GitHub Repo Url](/issues_list.png?raw=true "GitHub Issue Viewer")

● Documentation for the github issues API can be found here:
https://developer.github.com/v3/issues/

● Sample API link to fetch issues for a repo :
https://api.github.com/repos/pardom/ActiveAndroid/issues
