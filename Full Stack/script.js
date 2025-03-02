// Smooth scrolling for navigation links
document.querySelectorAll('nav ul li a').forEach(link => {
    link.addEventListener('click', function (event) {
        event.preventDefault();

        // Extract the target ID from the href attribute
        const targetId = this.getAttribute('href').substring(1);
        const targetElement = document.getElementById(targetId);

        // Check if the target element exists
        if (targetElement) {
            // Scroll to the target element with smooth behavior
            window.scrollTo({
                top: targetElement.offsetTop - 50, // Adjust for header height
                behavior: 'smooth'
            });
        } else {
            console.warn(`Element with ID '${targetId}' not found.`);
        }
    });
});
