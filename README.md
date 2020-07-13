# RobotRunner (Dependency Library)

RobotRunner lets you run robots that you can build by defining the back of strategies and commands. To run the Robot
you need specify the Robot (RobotEnum) and the json schema which contains the map, start point, commands and the battery level.

# RobotRunnerConsoleClient

RobotRunnerConsoleClient is a console client of RobotRunner that lets you run a robot (in this case Roomba Robot) with 2 params:
an input json file name (source) and output json file name (result). This will take the first as the schema and will save the 
results of processed robot in the second file.

# RobotRunnerServiceClient

RobotRunnerServiceClient is a microservice that lets you run a robot (in this case Roomba Robot) sending as param a json and returning back
the result json.

# Test and Run

Each project has a document describing how you can Test and Run it. 
It's required to compile the RobotRunner Dependency Library, so you need to run this command in RobotRunner:

`mvn clean install`
