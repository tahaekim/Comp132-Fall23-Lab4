# Lab-4 Prelab - Research Service

![](/img/research-service.png?raw=true "")

In this Lab, you are asked to implement the described operations for a research service using the concepts of **inheritance**. Please implement your project following the instructions below. You must make sure that the package names are exactly what is written.

## Resource Class

Create a package named **resource**, and inside the resource package, create a class called **Resource**. All the access modifiers of this class's fields should be **protected**.

### Instance Variables

```
  - String title
  - String field
  - int numDwnld
  - int likes
```
### Methods

- Create **getters and setters** for all fields.


- **public Resource(String title, String field):** Constructor for the Resource class.



- **public void addNumDwnld(boolean like)**:  A method that increments the value of the variable numDwnld, and if the value of the passed like argument is true, also increments the number of likes. 



- **public double getRating()**: A method that returns the **rating**, which is calculated by dividing the number of likes by the number of downloads. 

**Note:** What will happen if we have zero likes and/or zero downloads?


## Paper Class

Inside the **resource** package, create a class called **Paper**, which **inherits from the Resource class**. This class includes the following additional field and method:

```
 - String firstAuthor
```

**Note:** Don't forget to create the additional getter and setter for this new field.


- **public Paper(String title, String field, String firstAuthor):** The constructor for the Paper class.


## ProceedingBook Class

Inside the **resource** package, create a class called **ProceedingBook**, which **inherits from the Resource class**. This class represents a conference proceedings book, which includes the accepted papers of a conference. This class has the following additional fields and method:

```
 - int numPapers
 - int chapters
```

- **public ProceedingBook(String title, String field, int numPapers, int chapters):** The constructor for the ProceedingBook class.


## Researcher Class

Create the package **research**, and inside the research package, create a class called **Researcher**. All the access modifiers of this class's fields should be **protected**.

### Instance Variables

```
 - String researcherName
 - ArrayList <Resource> downloaded
 - ArrayList <Resource> liked
```

### Methods

- Create **getters and setters** for all fields.


- **public Researcher(String researcherName)**: Constructor for the Researcher class.


- **public void download(Resource m, boolean like)**: A method adds the resource to the downloaded list and increases the number of downloads for the resource. If the resource is liked by the researcher, it should also be added to the liked list.


- **public String getFavoriteField():** A method that counts the number of Resources (Papers and ProceedingBooks) liked for each field and returns the field that the Researcher liked the most.

```
- public ArrayList<Paper> getLikedPapers(): A method that creates and returns an
ArrayList of Papers the Researcher has liked.
```


**Note:** You can use the instanceof operator.

```
- public ArrayList<ProceedingBook> getLikedPapers(): A method that creates and returns an
ArrayList of ProceedingBooks the Researcher has liked.
```

**Note:** You can use the instanceof operator.


- **public double measureSimilarityWith(Researcher r)**: A method that measures the similarity of researchers in terms of the same resources (Papers and ProceedingBooks) they both liked. For example, if Researchers A and B both liked the Papers p1 and p2, and ProceedingBook pb1, their similarity will be 3.



## ResearchService Class

Inside the **research** package, create a class called **ResearchService**. All the access modifiers of this class's fields should be **protected**.

### Instance Variables

```
 - String serviceName
 - ArrayList <Researcher> researchers
 - ArrayList <Resource> resource
```

### Methods

- Create **getters and setters** for all fields.


- **public ResearchService(String serviceName)**: Constructor for the ResearchService class.


- **public void addResource(Resource m)**: A method that adds resource objects to the researching service's resource list.


- **public boolean addResearcher(Researcher researcher)**: A method that takes researcher object as an argument and adds it to the researcher list. If a researcher with the same researcherName exists in the researchers list, it should print 'Researcher with the same researcherName already exists.' and return false.


- **private Researcher getMostSimilarResearcher(Researcher researcher)**: A method that will return the most similar researcher in the researcher list to the given researcher. You can use the **measureSimilarityWith(Researcher r)** you have implemented earlier.


- **public Paper recommendPaperBySimilarResearcher(Researcher researcher)**:  A method that will recommend a Paper to the researcher that a similar researcher liked. Use `getMostSimilarResearcher` method to find the researcher method that will recommend a paper from and return a paper that a similar researcher has liked and the given researcher has not downloaded. Also, print the name of the most similar researcher with the similarity score inside the method. The recommended paper should be the first one in the list that a similar researcher has liked, and the current one hasn’t been downloaded yet.


- **public Resource recommendByField(Researcher researcher)**: A method that will return a Resource (Paper or ProceedingBook) with the researcher's favorite field. Note that the recommendation should not be downloaded before by the researcher. Also, print the favorite field of the researcher inside the method.

## Expected Output

 ```
Test with the existing researcher: 
Researcher with the same researcherName already exists.
Test recommending Paper by similar researcher: 
Most similar researcher is Emre with a score of 2.0
Blockchain meets FL
Test recommending Paper by field: 
Your favorite field is: Distributed Networks
Client selection in FL
```
