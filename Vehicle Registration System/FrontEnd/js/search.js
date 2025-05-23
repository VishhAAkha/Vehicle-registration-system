const input = document.getElementById("searchInput");
const results = document.getElementById("searchResults");

input.addEventListener("input", () => {
  const value = input.value.toLowerCase();
  results.innerHTML = "";
  const records = JSON.parse(localStorage.getItem("records")) || [];

  const filtered = records.filter(r =>
    r.customer.name.toLowerCase().includes(value) ||
    r.vehicle.registrationNumber.toLowerCase().includes(value)
  );

  if (filtered.length === 0) {
    results.innerHTML = "<p>No matches found.</p>";
  } else {
    filtered.forEach(r => {
      const div = document.createElement("div");
      div.className = "vehicle-card";
      div.innerHTML = `
        <h3>${r.customer.name}</h3>
        <p>${r.vehicle.registrationNumber} - ${r.vehicle.model}</p>
      `;
      results.appendChild(div);
    });
  }
});
