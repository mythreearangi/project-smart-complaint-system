const table = document.getElementById("complaintTable");

// Load all complaints
fetch("http://localhost:8080/complaints/all")
    .then(res => res.json())
    .then(data => {
        table.innerHTML = "";
        data.forEach(c => {
            table.innerHTML += `
                <tr>
                    <td>${c.id}</td>
                    <td>${c.description}</td>
                    <td>${c.category}</td>
                    <td>${c.priority}</td>
                    <td>${c.status}</td>
                    <td>
                        <select onchange="updateStatus(${c.id}, this.value)">
                            <option value="">Select</option>
                            <option value="In Progress">In Progress</option>
                            <option value="Resolved">Resolved</option>
                        </select>
                    </td>
                </tr>
            `;
        });
    });

// Update complaint status
function updateStatus(id, status) {
    if (status === "") return;

    fetch(`http://localhost:8080/complaints/update/${id}?status=${status}`, {
        method: "PUT"
    })
    .then(() => {
        alert("Status updated successfully");
        location.reload();
    });
}
