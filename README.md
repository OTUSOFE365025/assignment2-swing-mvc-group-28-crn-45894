# Answers to questions 1 and 2:

1) *Do some investigation into the Swing framework and write a short paragraph describing the purpose of the Swing framework. Submit a class diagram of the components of Swing.*

Swing is Java's GUI toolkit, similar to JavaFX and others. It is an older framework and used to create different components like buttons, labels, containers and panels. The main componnet is JContainer, and almost every component extends off of it. It allows you to change appearance during runtime as well as has the MVC model to seperate data from view. Overall, while quite outdated, Swing remains a solid choice for most developers looking to create Java applications. 
<img width="2556" height="1100" alt="SWINGUML" src="https://github.com/user-attachments/assets/637ed540-ec80-4c33-ae36-acecb64399c4" />

2) *Look through the example code in the GitHub repository and explain how this example implements the MVC pattern. How does it differ from the conventional MVC pattern described in the lectures?*

The example follows the MVC model as it divides the application into 3 seperate modules, Model, View Controller. The model holds and manages data, using getters and setters, while staying sepretae from the interfeace. The view holds the interface and it's main focus is displaying elements, and all other company logic will be handeled to other modules. The controller is like the middleman, connecting the view and model by reacting to user input, updating the Model, and modifying the View when necessary.

Our setup didnt follow MVC model propelry. in a traditional MVC the View automatically respond to changes in the Model. But for us, it goes through controller, which creates more coupling and doesnt follow the MVC model stricty, nonetheless, it demontrsates the idea of an MVC model,, and how it's supposed to function. 
