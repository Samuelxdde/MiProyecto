document.addEventListener('DOMContentLoaded', () => {
  const carrusel = document.getElementById('carrusel'); // div.imagen-contenedor con id="carrusel"
  const leftBtn = document.getElementById('left');      // botón con id="left" y clase .btizquierdo
  const rightBtn = document.getElementById('right');    // botón con id="right" y clase .btderecho

  if (!carrusel || !leftBtn || !rightBtn) {
    console.warn('Carrusel: faltan elementos requeridos (carrusel, left, right).');
    return;
  }

  let index = 0;
  const slides = Array.from(carrusel.children);

  function slideWidth() {
    // Usa el ancho del primer slide (asumimos todas las imágenes con mismo ancho)
    return slides[0]?.getBoundingClientRect().width || 0;
  }

  function updateCarrusel() {
    const width = slideWidth();
    carrusel.style.transform = `translateX(-${index * width}px)`;
  }

  function goNext() {
    index = (index + 1) % slides.length;
    updateCarrusel();
  }

  function goPrev() {
    index = (index - 1 + slides.length) % slides.length;
    updateCarrusel();
  }

  rightBtn.addEventListener('click', goNext);
  leftBtn.addEventListener('click', goPrev);

  // Ajusta la posición si cambia el tamaño de la ventana
  window.addEventListener('resize', updateCarrusel);

  // Inicializa en la primera imagen
  updateCarrusel();

  // Autoplay opcional (actívalo si quieres)
  // const AUTOPLAY_MS = 4000;
  // let timer = setInterval(goNext, AUTOPLAY_MS);
  // carrusel.parentElement.addEventListener('mouseenter', () => clearInterval(timer));
  // carrusel.parentElement.addEventListener('mouseleave', () => (timer = setInterval(goNext, AUTOPLAY_MS)));
});
