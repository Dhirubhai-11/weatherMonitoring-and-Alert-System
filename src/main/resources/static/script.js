async function searchWeather() {

    const city = document.getElementById("cityInput").value;

    if (city === "") {
        alert("Please enter a city name");
        return;
    }

    try {

        const response = await fetch(`/api/weather/${city}`);

        if (!response.ok) {
            throw new Error("City not found");
        }

        const data = await response.json();

         let citySearches = Number(localStorage.getItem("citySearches")) || 0;
            citySearches++;
            localStorage.setItem("citySearches", citySearches);

            const cityCounts = JSON.parse(localStorage.getItem("cityCounts")) || {};
            const searchedCity = data.city;

            cityCounts[searchedCity] = (cityCounts[searchedCity] || 0) + 1;

            localStorage.setItem("cityCounts", JSON.stringify(cityCounts));

        document.getElementById("cityName").textContent = data.city;
        document.getElementById("temperature").textContent =
            data.temperature + " °C";
        document.getElementById("condition").textContent =
            data.weatherDescription;

        document.getElementById("feelsLike").textContent =
            data.feelsLike;

        document.getElementById("humidity").textContent =
            data.humidity;

        document.getElementById("windSpeed").textContent =
            data.windSpeed;

        document.getElementById("pressure").textContent =
            data.pressure;
            document.getElementById("precaution").textContent =
                data.precaution;

    } catch (error) {

        alert(error.message);

    }

}