#!/bin/sh

# setup submodules
grep 'submodule[[:space:]]*\".*\"]' ./.gitmodules \
    | sed -e 's&\[submodule\s\+\"\(.*\)\"\]&\1&' \
    | while read dir; do
    echo "submodule: ${dir}"
    if [ ! -d $dir/.git ]; then
        git submodule init $dir
        git submodule update $dir
    fi

    if [ "$1" = "update" ]; then
        (cd $dir && git checkout master && git pull origin master)
    fi
done

# clone meta layers directly from URIs
DONE=false
until $DONE; do
    read -r url branch || DONE=true
    if [ ! -z ${url} ]; then
        [ -z ${branch} ] && branch=master
        git clone --branch ${branch} ${url}
    fi
done < ./LAYERS
