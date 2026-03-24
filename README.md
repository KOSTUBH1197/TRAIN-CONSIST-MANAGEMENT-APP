# Train Consist Management App

Console-based Core Java application for learning data structures through railway consist management scenarios.

## Current Use Case

- `UC1`: Initialize train and display consist summary
- `UC2`: Add passenger bogies to train using `ArrayList` operations
- `UC3`: Track unique bogie IDs using `HashSet`
- `UC4`: Maintain ordered train consist using `LinkedList`
- `UC5`: Preserve insertion order of bogies using `LinkedHashSet`

## Project Structure

- `src/com/trainconsist/model`: shared domain classes
- `src/com/trainconsist/usecase1`: UC1 implementation
- `src/com/trainconsist/usecase2`: UC2 implementation
- `src/com/trainconsist/usecase3`: UC3 implementation
- `src/com/trainconsist/usecase4`: UC4 implementation
- `src/com/trainconsist/usecase5`: UC5 implementation

## Compile

```powershell
javac -d out (Get-ChildItem -Recurse -Filter *.java .\src | ForEach-Object { $_.FullName })
```

## Run UC1

```powershell
java -cp out com.trainconsist.usecase1.UseCase1InitializeTrainAndDisplayConsistSummary
```

## Run UC2

```powershell
java -cp out com.trainconsist.usecase2.UseCase2AddPassengerBogiesToTrain
```

## Run UC3

```powershell
java -cp out com.trainconsist.usecase3.UseCase3TrackUniqueBogieIds
```

## Run UC4

```powershell
java -cp out com.trainconsist.usecase4.UseCase4MaintainOrderedBogieIds
```

## Run UC5

```powershell
java -cp out com.trainconsist.usecase5.UseCase5PreserveInsertionOrderOfBogies
```
