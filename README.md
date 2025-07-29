# Santander Dev Week 23
Java RESTful API criada para a Santander dev week '23

## Diagrama de Classes

```mermaid
classDiagram
    class User {
        -String name
        -Account account
        -Feature[] features
        -Card card
        -News[] news
    }

    class Account {
        -String number
        -String agency
        -Number balance
        -Number limit
    }

    class BaseItem {
        -String icon
        -String description
    }

    class Card {
        -String number
        -Number limit
    }
    
    class Feature {
        
    }

    class News {
        
    }

    User "1" *-- "1" Account
    User "1" *-- "N" Feature
    User "1" *-- "1" Card
    User "1" *-- "N" News
    BaseItem <|-- Feature
    BaseItem <|-- News
```
