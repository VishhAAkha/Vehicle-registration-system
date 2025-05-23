document.getElementById("registerForm").addEventListener("submit", function (e) {
    e.preventDefault();
  
    const customer = {
      name: document.getElementById("name").value,
      email: document.getElementById("email").value,
      phone: document.getElementById("phone").value,
    };
  
    const vehicle = {
      registrationNumber: document.getElementById("registrationNumber").value,
      type: document.getElementById("type").value,
      model: document.getElementById("model").value,
      color: document.getElementById("color").value,
    };
  
    const data = { customer, vehicle };
  
    let records = JSON.parse(localStorage.getItem("records")) || [];
    records.push(data);
    localStorage.setItem("records", JSON.stringify(records));
  
    alert("Registered successfully!");
    document.getElementById("registerForm").reset();
  });
  