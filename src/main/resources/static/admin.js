
document.addEventListener("DOMContentLoaded", function () {
    // Total page visits from this browser
    const pageVisits = Number(localStorage.getItem("pageVisits")) || 0;

    document.getElementById("pageVisits").textContent = pageVisits;

    // Total city searches from this browser
    const citySearches = Number(localStorage.getItem("citySearches")) || 0;

    document.getElementById("citySearches").textContent = citySearches;

    // Most searched city from this browser
    const cityCounts = JSON.parse(localStorage.getItem("cityCounts")) || {};

    let popularCity = "--";
    let maxSearches = 0;

    for (const city in cityCounts) {
        if (cityCounts[city] > maxSearches) {
            maxSearches = cityCounts[city];
            popularCity = city;
        }
    }

    document.getElementById("popularCity").textContent = popularCity;
});
