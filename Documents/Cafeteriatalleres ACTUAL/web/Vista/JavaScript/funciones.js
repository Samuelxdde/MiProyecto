/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

const contenedor = document.getElementById("carrusel");
const btnIzq = document.getElementById("left");
const btnDer = document.getElementById("right");

let index = 0;
const total = contenedor.children.length;

btnDer.addEventListener("click", () => {
  if (index < total - 1) index++;
  contenedor.style.transform = `translateX(-${index * 600}px)`;
});

btnIzq.addEventListener("click", () => {
  if (index > 0) index--;
  contenedor.style.transform = `translateX(-${index * 600}px)`;
});
