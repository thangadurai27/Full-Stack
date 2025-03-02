// JavaScript to handle the navigation and section switching

// Function to show the active section and hide the others
function showSection(sectionId) {
    // Hide all sections
    const sections = document.querySelectorAll('.section');
    sections.forEach(section => {
        section.classList.remove('active');
    });

    // Show the selected section
    const activeSection = document.getElementById(sectionId);
    activeSection.classList.add('active');
}

// Event listeners for the navigation buttons
document.getElementById('home-btn').addEventListener('click', function() {
    showSection('home');
});

document.getElementById('menu-btn').addEventListener('click', function() {
    showSection('menu');
});

document.getElementById('about-btn').addEventListener('click', function() {
    showSection('about');
});

document.getElementById('contact-btn').addEventListener('click', function() {
    showSection('contact');
});

// Initial display setup (show the home section by default)
window.onload = function() {
    showSection('home');
};
