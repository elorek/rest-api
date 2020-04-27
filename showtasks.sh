#!/usr/bin/env bash

start_script() {
  if call runcrud.sh; then
    echo "Script called successfully"
  else
    echo "Script cannot be called"
    fail
  fi
}

open_web_browser() {
  open -a Safari http://localhost:8080/crud/v1/task/getTasks
}

fail() {
  echo "There were errors"
}

exit() {
  echo "Work is finished"
}

if start_script; then
  open_web_browser
else
  fail
fi