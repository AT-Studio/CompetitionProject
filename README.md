# CompetitionProject


### Prototype 1 Demo

![](demo1PingPongParty.gif)
![](demo2PingPongParty.gif)


### Prototype 2 Progress
- Documented our classes using JavaDocs
- Added FXML-tagged fields and methods within controllers for buttons and other elements.
- Set up local H2 database and created tables
- Set up Sign Up and Log In buttons within login.fxml to query the database.
- Added model classes User, Tournament, and OneVOneStats
- Set up the ScoreEntryController to add 1v1 match information to the database
 
### Prototype 2 Demo

### Git Basics
- The master branch is only merged to after we have tested a feature within the dev branch and confirmed that it works.
- The dev branch is merged with only if the feature works as expected on the local version.

### How to Create a New Branch
- We will only create a new branch to add a feature and this is only done one time for each branch. 
- Performing these operations twice will create a duplicate.

```
git checkout dev         // Switch to branch named "dev"
git branch new_branch    // Creates new branch named "new_branch"
git checkout new_branch  // Switch to new_branch
```

### How to Merge a Branch
- When your local changes are working and you are ready to merge a branch with another we use this.

```
git checkout dev        // Switch to the destination named "dev"
git merge new_branch    // Merges new_branch changes to branch "dev"
```
