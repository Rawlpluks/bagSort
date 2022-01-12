@startuml

class simulation{
    int numberOfGenerations
    int startIndividualsPerGeneration
    int individualShortendPerGeneration
    int itemSet_ID
    int maxWeight
    int bestValue
    int worstValue
    int averageValue
    int timeUsed
    Graph graph

}

class itemSet{
    int itemSet_ID
    ArrayList<Item> items
}

class Graph{

}

class Item{

}

@enduml