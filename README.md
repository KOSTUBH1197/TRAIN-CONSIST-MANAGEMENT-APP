# Train Consist Management App

Console-based Core Java application for learning data structures through railway consist management scenarios.

## Current Use Case

- `UC1`: Initialize train and display consist summary
- `UC2`: Add passenger bogies to train using `ArrayList` operations
- `UC3`: Track unique bogie IDs using `HashSet`
- `UC4`: Maintain ordered train consist using `LinkedList`
- `UC5`: Preserve insertion order of bogies using `LinkedHashSet`
- `UC6`: Map bogie to capacity using `HashMap`
- `UC15`: Safe cargo assignment using `try-catch-finally`
- `UC16`: Sort passenger bogie capacities using bubble sort
- `UC17`: Sort bogie names alphabetically using `Arrays.sort()`
- `UC18`: Search for a bogie ID using linear search
- `UC19`: Search for a bogie ID using binary search
- `UC20`: Prevent search on an empty train using `IllegalStateException`

## Project Structure

- `src/com/trainconsist/model`: shared domain classes
- `src/com/trainconsist/usecase1`: UC1 implementation
- `src/com/trainconsist/usecase2`: UC2 implementation
- `src/com/trainconsist/usecase3`: UC3 implementation
- `src/com/trainconsist/usecase4`: UC4 implementation
- `src/com/trainconsist/usecase5`: UC5 implementation
- `src/com/trainconsist/usecase6`: UC6 implementation
- `src/com/trainconsist/usecase15`: UC15 implementation
- `src/com/trainconsist/usecase16`: UC16 implementation
- `src/com/trainconsist/usecase17`: UC17 implementation
- `src/com/trainconsist/usecase18`: UC18 implementation
- `src/com/trainconsist/usecase19`: UC19 implementation
- `src/com/trainconsist/usecase20`: UC20 implementation

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

## Run UC6

```powershell
java -cp out com.trainconsist.usecase6.UseCase6MapBogieToCapacity
```

## Run UC15

```powershell
java -cp out com.trainconsist.usecase15.UseCase15SafeCargoAssignmentUsingTryCatchFinally
```

## Run UC16

```powershell
java -cp out com.trainconsist.usecase16.UseCase16SortPassengerBogieCapacitiesUsingBubbleSort
```

## Run UC17

```powershell
java -cp out com.trainconsist.usecase17.UseCase17SortBogieNamesUsingArraysSort
```

## Run UC18

```powershell
java -cp out com.trainconsist.usecase18.UseCase18LinearSearchForBogieId
```

## Run UC19

```powershell
java -cp out com.trainconsist.usecase19.UseCase19BinarySearchForBogieId
```

## Run UC20

```powershell
java -cp out com.trainconsist.usecase20.UseCase20ExceptionHandlingDuringSearchOperations
```
