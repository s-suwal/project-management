new Chart(document.getElementById("myPieChart"), {
	type: 'pie',
	data: {
      labels: ['Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange'],
      datasets: [{
        label: '# of Votes',
        data: [12, 19, 3, 5, 2, 3],
        borderWidth: 1
      }]
    },
    //Configuration options go here
    options:{}
});