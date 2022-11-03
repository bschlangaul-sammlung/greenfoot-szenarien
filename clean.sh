#! /bin/sh

FOLDER="$1"

if [ -z "$FOLDER" ]; then
  echo "Usage: $0 <folder>

For example:

  $0 src/main/java/org/bschlangaul/greenfootscenarios/mario/nolttr21
"
  exit 1
fi

_clean_file() {
  sed -i 's#// (World, Actor, GreenfootImage, Greenfoot and MouseInfo)##g' "$1"
  sed -i '/@author (your name)/d' "$1"
  sed -i '/@version (a version number or a date)/d' "$1"
}

for FILE in $(find ${FOLDER} -iname "*.java"); do
  echo "Clean $FILE"
  _clean_file "$FILE"
done
