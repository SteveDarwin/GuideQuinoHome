# GuideQuinoHome
A Java-based game to help Quino-The Superbot find the minimum number of steps to reach his source.

Project Description:
1. Quino.java - This class specifies the entire game play based on user input and provides the shortest way to guide Quino home.
2. QuinoInput.java - This class retreives the user input and passes it for game play.
3. QuinoValidator.java - This class consists of validations that ensure game rules are followed.

Input (specified in QuinoInput.java): - a string of comma-separated commands eg. "F1,R1,B2,L1,B3"
Output: - 4

Game Rules:
1. Input string cannot be blank and should contain valid alphanumeric characters with comma as delimiter. 
   The valid alphabets (denoted as moves) are 
   'F' - Move Forward/North, 'B'- Move Backward/South, 'R' - Move Right/East and 'L' - Move Left/West
2. Any valid move cannot have zero steps. For eg. "F0" is not allowed
3. Number of steps made by robot while turning right or left cannot be more than one. For eg. "R2" is not allowed
4. The robot can only turn 90 degrees once consecutively. For eg. "F1,R1,L1,B3" is not allowed
5. The robot cannot return home immediately. For eg. "F1,R1,B1" is not allowed

Note: It does not matter if the user has entered moves in lower or uppercase but leaving blanks is a non-negotiable offence. 
      Also, it does not matter which position the robot is facing in his last move, what matters is to guide him home quickly.
