const orderList = document.getElementById("orderList");
const records = JSON.parse(localStorage.getItem("records")) || [];

if (records.length === 0) {
  orderList.innerHTML = "<p>No orders found.</p>";
} else {
  records.forEach((r, i) => {
    const div = document.createElement("div");
    div.className = "vehicle-card";
    div.innerHTML = `
      <h3>Order #${i + 1}</h3>
      <p>${r.customer.name} - ${r.vehicle.registrationNumber}</p>
    `;
    orderList.appendChild(div);
  });
}
