The task for this lab is to design a multithreaded system following Observer pattern. You must have the following subjects and observers:
 TemperatureSensor is a subject that logs temperature values every 5 seconds at 3 different locations. You may simply generate random temperature values every 5 seconds at these 3 locations and maintain in a TemperatureLog object.
o TemperatureLogisaclassthattakestemperatureandlocationsasit’sconstructor arguments and implements getters and setters for the same. Eg. new TemperatureLog(36,”Delhi”);
So the observer should be updated with the TemperatureLog.
Since the data is being logged simultaneously at all three locations(say Delhi, Mumbai, Srinagar) you must make use of different threads handling the temperature generator for each of the location.
At the start of the system assume the initial values are 35 degrees for all the three locations.
For the given subject we have four types of observers:
 SerializeTemperature is an observer that on receiving the data i.e the TemperatureLog
object serializes it to a file.
 TemperaturePredictor1 is the observer that receives the data from the TemperatureSensor
and predicts the likely temperature at all three locations in the next 5 seconds and displays. o Youmayuseabasicslidingwindowbasedpredictionalgorithmthattakesthelatest
5 values returns the average of them as the predicted temperature.
 TemperaturePredictor2 is another observer that receives the data from the
TemperatureSensor and predicts the likely temperature at all three locations in the next 5 seconds and displays. For this observer, design a temperature predictor algorithm of your own.
 GenerateStats is the observer that on receiving the data returns/displays the following statistics for every location for the last 100 records:
o MeanTemperature
o MedianTemperature
o MaximumTemperature o MinimumTemperature
Register atleast 4 observer objects in your main method (1 of each kind described above)-, say WeatherLog, BBC, Yahooweather, GoogleWeatherStats each observing the TemperatureSensor.
Bonus:
Develop your own random number generator instead of using the Random number generator provided in the Java util package
