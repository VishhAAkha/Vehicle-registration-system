const list = document.getElementById("vehicleList");
const records = JSON.parse(localStorage.getItem("records")) || [];

if (records.length === 0) {
  list.innerHTML = "<p>No vehicles Registered.</p>";
} else {
  records.forEach((record, i) => {
    const item = document.createElement("div");
    item.className = "vehicle-card";
    item.innerHTML = `
      <h3>${record.customer.name}</h3>
      <p>Vehicle: ${record.vehicle.model} (${record.vehicle.registrationNumber})</p>
      <p>Type: ${record.vehicle.type}</p>
      <p>Color: ${record.vehicle.color}</p>
    `;
    list.appendChild(item);
  });
}
