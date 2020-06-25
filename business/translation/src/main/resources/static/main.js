function loadTable() {
    const requestEndpoint = "/lang";
    const xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            const data = JSON.parse(this.responseText);
            console.log(data);
            let html = '';
            $.each(data, function(index, value){
                html += '<table class="table table-striped">';
                html += '<tr>';
                html += '<h2>'+value.locale+'</h2>';
                html += '<th>'+'key'+'</th>';
                html += '<th>'+'value'+'</th>';
                $.each(value.dictionary, function(index2, value2){
                    html += '<tr>';
                    html += '<td>'+index2+'</td>';
                    html += '<td>'+value2+'</td>';
                    html += '</tr>';
                });
                html += '</tr>';
                html += '</table>';
            });
            document.getElementById("demo").innerHTML = html;
        }
    };
    xhttp.open("GET", requestEndpoint, true);
    xhttp.send();
}
