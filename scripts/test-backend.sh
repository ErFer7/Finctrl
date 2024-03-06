echo "Testing backend"

cd ../database

echo "Preparing the database"

python3 migrator.py --db test.sqlite
mv test.sqlite ../backend/test/test.sqlite

cd ../backend

echo "Running tests"

pytest

echo "Cleaning up"

rm test/test.sqlite

echo "Done"
