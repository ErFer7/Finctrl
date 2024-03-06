# Clean backend

echo "Cleaning backend"

cd ..
find . -type d -name "__pycache__" -exec rm -r {} +
find . -type d -name ".pytest_cache" -exec rm -r {} +

echo "Backend cleaned"
