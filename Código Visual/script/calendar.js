document.addEventListener('DOMContentLoaded', function() {
  var calendarEl = document.getElementById('calendario');
  var calendar = new FullCalendar.Calendar(calendarEl, {
    initialView: 'dayGridMonth',
    locale: 'es',              
    initialDate: new Date(),   
    events: [
      {
        title: 'Entrega proyecto',
        start: '2026-02-10',
        color: '#ff7f50'
      },
      {
        title: 'Clase de React',
        start: '2026-02-15T14:00:00',
        end: '2026-02-15T16:00:00',
        color: '#6495ed'
      }
    ]
  });
  calendar.render();
});