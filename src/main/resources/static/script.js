document.addEventListener('DOMContentLoaded', function() {
    const carList = document.getElementById('carList');
    const cards = document.querySelectorAll('.card');

    // Set up IntersectionObserver
    const observerOptions = {
        root: carList,
        rootMargin: '0px',
        threshold: 0.5 // 50% of the card must be visible to consider it as active
    };

    const observer = new IntersectionObserver((entries) => {
        entries.forEach(entry => {
            if (entry.isIntersecting) {
                entry.target.classList.add('active');
                resizeActiveCard(entry.target);
            } else {
                entry.target.classList.remove('active');
                resetCardSize(entry.target);
            }
        });
    }, observerOptions);

    cards.forEach(card => {
        observer.observe(card);
    });

    function resizeActiveCard(card) {
        card.style.transform = 'scale(1.2)';
        card.style.width = '240px';
        card.style.height = '120px';
    }

    function resetCardSize(card) {
        card.style.transform = 'scale(1)';
        card.style.width = '200px';
        card.style.height = '100px';
    }

    // Ensure the active card is centered when scrolling
    carList.addEventListener('scroll', () => {
        const activeCard = document.querySelector('.card.active');
        if (activeCard) {
            activeCard.scrollIntoView({ behavior: 'smooth', block: 'center' });
        }
    });
});
