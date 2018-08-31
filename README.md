# MinesWeeperPSL
Execution instructions: My program runs in Java 8.0, run -java Minesweeper.jar to start.
Aditional comments: The program validate:
a. When ints aren't a valid character.
b. If users write a number outofBounds (row or column).
c. When the square is already marked for the user.
d. It starts differents rounds when you lost or win, if the user chose.
f. The number of mines need to be less or equal the 60% height * weight. I considered it because it won't be nice a game 
if all grid is full of mines.
e. The game close when the users introduce a not valid information in the rows or column, when user marks a not valid option when
the program ask if it wanna keeps another round or stop, and finally, when the program ask if wanna keep playing and user says N.
f. There are 2 times program receive information from the user, to be able to start the game or to move all over the grid:
  f.1. First, the height and weight of grid and the numbers of mines.
  f.2. Scond, the number of row, the number of column and action U "Uncover" the position, "P" to write P or flag in the position.
g. f.2. Repeat until the game finish for some reason: WIN, LOST or the reasons wrote in the item e.
