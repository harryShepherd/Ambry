# Branches Guidelines

---

## Branches Legend

---

| Instance       |     Branch      |                                       Description/Instructions |
|----------------|:---------------:|---------------------------------------------------------------:|
| Stable Release |     release     |                Accepts merges from Working and Hotfix **only** |
| Working        |     master      |              Accepts merges from Development, Feature & Bugfix |
| Development    |     develop     |                                   Always branch off of Working |
| Feature        |    feature-*    |                               Always branch off of Development |  
| Bugfix/Hotfix  | bugfix/hotfix-* | Branch off of master for Bugfix, and Stable Release for Hotfix |

## Main Branches

---

Consider `master` as the main branch. This is where shippable production code should be going, waiting to be merged
into `release`.

Consider `release` as the branch with latest code deployed to production. During typical development, this branch won't
be interacted with.

Consider `develop` to be the main development branch. As a developer, you should be branching off of, and merging into this branch.

When sourcecode in `master` is in a stable and deliverable state, it can be merged into `release` and tagged with a release
version.

## Supporting Branches

---

The supporting branches, `feature` & `bugfix`/`hotfix` are used in parallel with the `develop` branch to aid with development between
team members, to track development of features, and to fix issues present in branches.

These are usually only temporary. Once the feature is added, or the bug is fixed, the branch will be merged into `develop` and then
deleted.

- Feature branch naming convention: `feature-<id>`
- Bugfix/Hotfix branch naming convention: `bugfix/hotfix-<id>`

Consider `feature` as the main development branch, used for developing new features or enhancements.
The feature branch must be branched off of, and merge back into `develop`.

Consider `bugfix`/`hotfix` as the bug fixing branch. If a bug is found in `master` or `develop`, create a `bugfix` branch.
If a bug is found in `release`, create a `hotfix` branch to fix it.

## Working with a supporting branch

---

If the branch does not exist yet (check with Project Owner), create the branch locally then push to GitHub. A supporting branch
should always be set to 'public' - we don't want development to be in just one developer's local branch!

```
// create a branch called 'feature-<id>' that branches off of develop
$ git checkout -b feature-<id> develop

// allows the supporting branch to be accessed remotely
$ git push origin feature-<id>
```

If changes are made to the `develop` branch, they should ideally be merged into your supporting branch.

```
// merges changes from develop into supporting branch
$ git merge develop
```

When the supporting branch is complete, be it a feature is finish or a bug is fixed, the Product Owner should merge it into the
`develop` branch and delete the feature branch.

```
// change to development branch
$ git checkout develop

// merge the branch, and create a commit
$ git merge --no-ff feature-<id>

// push merge changes
$ git push origin develop

// deletes now redundant supporting branch
$ git push origin :feature-<id>
```

## Version Convention

--- 

When tagging a branch, the tag for the version should be `vX.Y.Z` e.g. `v1.2.3`

- X being the release version and updated when pushing to release
- Y being the working version and updated when pushing to working branch
- Z being supporting version, e.g., bug fixes, spelling corrections
