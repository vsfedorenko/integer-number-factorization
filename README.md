Integer Number Factorization
============================



Usage example:
--------------

### Directory structure ###
    project-directory
    └─── README.md
    └─── .........
    │
    └───factorization-app
    │   └─── .......
    │   │
    │   └───target
    │       │    input.txt
    │       │    output.txt
    │       └─── factorization-app-1.0-RELEASE.jar
    │   
    └───factorization-api    
        └─── ......
        
### Call example ###
    
    java -jar factorization-app/target/factorization-app-1.0-RELEASE.jar
   
### The input.txt ###
        
    4343
    1312312
    42432
    54245
    113443
    4554324
    7543123
    43
    430294
    900743
    3435
    8954
    12345
    432155
    90998
    
### The output.txt will be ###
    
    +---------+-----------------------+
    |  Number |      Multipliers      |
    +---------+-----------------------+
    | 4343    | 43 * 101              |
    | 1312312 | 2^3 * 164039          |
    | 42432   | 2^6 * 3 * 13 * 17     |
    | 54245   | 5 * 19 * 571          |
    | 113443  | 11 * 10313            |
    | 4554324 | 2^2 * 3^2 * 73 * 1733 |
    | 7543123 | 7 * 83 * 12983        |
    | 43      | 43                    |
    | 430294  | 2 * 61 * 3527         |
    | 900743  | 900743                |
    | 3435    | 3 * 5 * 229           |
    | 8954    | 2 * 11^2 * 37         |
    | 12345   | 3 * 5 * 823           |
    | 432155  | 5 * 19 * 4549         |
    | 90998   | 2 * 45499             |
    +---------+-----------------------+