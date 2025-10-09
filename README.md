# Answers to questions 1 and 2:

1) *Do some investigation into the Swing framework and write a short paragraph describing the purpose of the Swing framework. Submit a class diagram of the components of Swing.*

Swing is Java's GUI toolkit, similar to JavaFX and others. It is an older framework and used to create different components like buttons, labels, containers and panels. The main componnet is JContainer, and almost every component extends off of it. It allows you to change appearance during runtime as well as has the MVC model to seperate data from view. Overall, while quite outdated, Swing remains a solid choice for most developers looking to create Java applications. 
<img width="2556" height="1100" alt="SWINGUML" src="https://github.com/user-attachments/assets/637ed540-ec80-4c33-ae36-acecb64399c4" />

2) *Look through the example code in the GitHub repository and explain how this example implements the MVC pattern. How does it differ from the conventional MVC pattern described in the lectures?*

The example code provided in the repository follows the MVC model, as it divides the application into three seperate modules: Model, View, Controller. The model holds and manages data, using getters and setters, while staying separate from the interface. The view holds the interface and it's main focus is displaying elements, and all other company logic will be handled by other modules. The controller acts as the "middleman": connecting the view and model by reacting to user input, updating the Model, and modifying the View when necessary.

Our setup did not follow the MVC model in the usual sense. In a traditional MVC, the View automatically responds to changes in the Model. But in this case, it goes through controller, which creates more coupling and does not follow the MVC model stricty. Nonetheless, it demontrsates a way to implement the idea of an MVC model, even if not in the most ideal way.
