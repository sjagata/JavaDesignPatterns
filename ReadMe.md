
You probably have heard about SOLID principles: 

* Single Responsibility
* Open-Closed
* Liskov Substitution
* Interface Segregation 
* Dependency Inversion. 

 Single responsibility principle:
 
 SRP Force you to put one Responsibility into any single class - if we add more responsibilities while you end up with something that is very unmanageable.
 
 The single responsibility principle is a computer programming principle that states that every module, class, or function
 should have responsibility over a single part of the functionality provided by the software, and that responsibility should be entirely encapsulated by the class.
 All its services should be narrowly aligned with that responsibility.

The first letter, S, represents Single Responsibility Principle (SRP) and its importance cannot be overstated. 
I would even argue that it is a necessary and sufficient condition for good code. 
In fact, in any code that is badly written, you can always find a class that has more than one responsibility - form.cs or index.php containing a few thousand lines of code 
is not something that rare to come by and all of us probably have seen or done it.


Open–closed principle:

"software entities (classes, modules, functions, etc.) should be open for extension, but closed for modification" that is, such an entity can allow its behaviour to be extended without modifying its source code.


Liskov Substitution Principle:

Functions that use pointers or references to base classes must be able to use objects of derived classes without knowing it.
At its heart LSP is about interfaces and contracts as well as how to decide when to extend a class vs. use another strategy such as composition to achieve your goal.


Interface segregation principle:

ISP states that no client should be forced to depend on methods it does not use.