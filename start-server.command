#!/bin/sh
set -eu

# Resolve the project from this script, even when opened from Finder.
cd -- "$(dirname -- "$0")"
exec sh ./gradlew --console=plain --no-daemon runServer "$@"
