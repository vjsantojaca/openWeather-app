# Open Weather App
OpenWeather
Use the OpenWeather API call http://openweathermap.org/forecast5 to retrieve data for displaying weather forecast by every 3 hours for upcoming 5 days for specific city in UK.

Present data in visual layout, where every day represents a row and every 3 hours weather forecast represents a cell in a row. User has to be able to scroll the cells within the row.
Each row should clearly show date and each cell in the row should clearly show temperature and time of the day. Present city/town/postcode as well, whatever applicable.

Make the same version of visual presentation (use perhaps radio button/ segmented control, whatever more appropriate for the platform to, to switch between), but don’t read from OpenWeather API, but from a CSV file, which you can create yourself in a following format with the same data you got from API call, but for simplicity sake you put only the data you need, like date, time and temperature:
2017-07-23 09:00:00,291.12, 
2017-07-23 12:00:00,292.00,
2017-07-23 15:00:00,289.34 ....

You can add quotes, if you like, with or without line breaks, important is it is a simple CSV file.

# More information
The API is called without problem (and read the information) and in the same way with the CSV. I have some problems to print it with Kotlin and the Fragments (the ListFragmentCSV is not loaded as I expected), I'm new on it 😅😅😅 (in kotlin language) So, I am going to continue to work on it.
