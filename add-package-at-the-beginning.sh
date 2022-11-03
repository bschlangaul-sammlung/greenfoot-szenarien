#! /bin/sh


FOLDER="$1"
PACKAGE_SUBFOLDER="$2"

if [ -z "$PACKAGE_SUBFOLDER" ]; then

  echo "Usage: $0 <folder> <package>

For example:

  $0 src/main/java/org/bschlangaul/greenfootscenarios/mario/nolttr21 mario.nolttr21
"
  exit 1
fi

PACKAGE="package org.bschlangaul.greenfootscenarios.${PACKAGE_SUBFOLDER};

"

for FILE in $(find ${FOLDER} -iname "*.java"); do

  echo "$FILE"
  CONTENT="${cat $FILE}"

  echo "$PACKAGE$CONTENT" > "$FILE"
done
