#!/bin/bash

git fetch --all

# note the SHA-1 of latest commit
git checkout master
# reset your branch head to your previously detached commit
git reset --hard

git config --global push.default matching
git config --global push.default simple

email="email"
name="name"

read -p "Email : " email
read -p "Name : " name

git config --global user.email "$email"
gut config --global user.name "$name"

echo "DONE"


