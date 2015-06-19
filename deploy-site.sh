git checkout -b gh-pages
git checkout gh-pages
gradle javadoc
git add --all
git commit -m "updated gh pages"
git push -f origin gh-pages
git checkout master
git branch -D gh-pages
echo "Done!"
