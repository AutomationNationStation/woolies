This framework was created by Peter conneely for Ampion. I created a Maven project and used Java with cucumber steps to achieve execution.

I used Intellij as the environment. When opening the project please open it as a Maven project.

Pre-requesties needed to launch the test are:

Environment:

-Intellij or Eclipse.

Coding language:

-Java 8

Plugins:

-Cucumber for Java

-Gherkin

To Launch the test simply navigate to the feature file "GenerateWeatherSummary.feature" and open it, then right click and select Run 'Scenario: Output Sydney Weather'.

The test will be finished and passed in less than 2 seconds.

The information that the person is looking for will be in the logs.

I chose Unirest library to execute the HTTP Request.

The feature file is dynamic so if the user wants to find out weather for a different city they can just change it.

 