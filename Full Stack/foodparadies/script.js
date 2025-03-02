
// Dynamic Greeting Based on Time
document.addEventListener("DOMContentLoaded", () => {
    const hours = new Date().getHours();
    const greeting =
        hours < 12
            ? "Good Morning, Foodie!"
            : hours < 18
            ? "Good Afternoon, Foodie!"
            : "Good Evening, Foodie!";
    document.querySelector(".p1").textContent = greeting;
});

// Confirm Before Visiting External Links
document.querySelectorAll("a.atag").forEach((link) => {
    link.addEventListener("click", (event) => {
        const confirmVisit = confirm("You are about to leave the page. Continue?");
        if (!confirmVisit) event.preventDefault();
    });
});

// Highlight Food Categories on Hover
document.querySelectorAll(".box1, .box2, .box3, .box4, .box5, .box6").forEach((box) => {
    box.addEventListener("mouseenter", () => {
        box.style.boxShadow = "10px 10px 20px rgba(0, 0, 0, 0.5)";
    });
    box.addEventListener("mouseleave", () => {
        box.style.boxShadow = "5px 5px rgba(100, 149, 25)";
    });
});
