# Train Consist Management App

Console-based Core Java application for learning data structures through railway consist management scenarios.

## Current Use Case

- `UC1`: Initialize train and display consist summary

## Project Structure

- `src/com/trainconsist/model`: shared domain classes
- `src/com/trainconsist/usecase1`: UC1 implementation

## Compile

```powershell
javac -d out (Get-ChildItem -Recurse -Filter *.java .\src | ForEach-Object { $_.FullName })
```

## Run UC1

```powershell
java -cp out com.trainconsist.usecase1.UseCase1InitializeTrainAndDisplayConsistSummary
```
