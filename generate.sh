#!/bin/bash

# Original file (e.g. simple_1_actual.yaml)
INPUT_FILE="$1"

if [[ ! -f "$INPUT_FILE" ]]; then
  echo "Error: File '$INPUT_FILE' not found."
  exit 1
fi

# Extract prefix, index, and suffix using regex
if [[ "$INPUT_FILE" =~ ^(.*_)([0-9]+)(_.*\.ya?ml)$ ]]; then
  PREFIX="${BASH_REMATCH[1]}"
  START_INDEX="${BASH_REMATCH[2]}"
  SUFFIX="${BASH_REMATCH[3]}"
else
  echo "Error: Filename must match pattern <prefix>_<number><suffix>.yaml"
  exit 1
fi

# Component names
COMPONENTS=(
  "web-service-a"
  "web-service-b"
  "web-service-c"
  "web-service-d"
  "web-service-e"
  "web-service-f"
  "web-service-g"
  "web-service-h"
  "web-service-i"
  "web-service-j"
)

# Generate copies with incremented index and replaced name
for i in "${!COMPONENTS[@]}"; do
  index=$((START_INDEX + i + 1))  # start from next index
  component="${COMPONENTS[$i]}"
  output_file="${PREFIX}${index}${SUFFIX}"

  sed "s/web-service/$component/g" "$INPUT_FILE" > "$output_file"
  echo "Created $output_file with name replaced to $component"
done
