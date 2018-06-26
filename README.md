== RobotRunner (Dependency Library)

RobotRunner lets you run robots that you can build. Defining its back of strategies and commands. For run the Robot
you need specify the Robot (RobotEnum) and its json schema, contains its map, start point, commands and its battery level.

== RobotRunnerConsoleClient

RobotRunnerConsoleClient is a console client of RobotRunner that lets you run a robot (in this case Roomba Robot) with 2 params:
an input json file name (source) and output json file name (result). This will take the first file to take the robot schema and will save the 
results of processed robot in the second file.

== RobotRunnerServiceClient

RobotRunnerServiceClient is a microservice that let you run a robot (in this case Roomba Robot) sending as param a json and returning back
the result json.

== Test and Run

Each project has a document describing how youn can Test and Run it. 
For all clients is required compile the RobotRunner Dependency Library, so you need first run this command in the project RobotRunner:

----
mvn clean install
----