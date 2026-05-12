document.getElementById("complaintForm").addEventListener("submit", function (e) {
    e.preventDefault();

    const data = {
        description: document.getElementById("description").value,
        priority: 0   // placeholder, AI will decide actual priority
    };

    fetch("http://localhost:8080/complaints/submit", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(data)
    })
    .then(response => response.json())
    .then(result => {
        document.getElementById("message").innerText =
            "✅ Complaint submitted successfully. AI is processing it.";
        document.getElementById("complaintForm").reset();
    })
    .catch(error => {
        document.getElementById("message").innerText =
            "❌ Error submitting complaint";
    });
});
