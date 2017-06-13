function myFunction(filtro) {
    var valor = document.querySelector(filtro).value;
    var filter, table, tr, td, i;
    console.log(document.querySelector(filtro));
    console.log(document.querySelector(filtro).value);
    console.log(valor);
    
  table = document.getElementById("tabela");
  tr = table.getElementsByTagName("tr");
  console.log(tr);
  filter = valor.toUpperCase();
  console.log(filtro);
    
  for (i = 1; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[5];
      console.log(td);
      
    if (td) {
      if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
          console.log(td.innerHTML);
        console.log("filtro nada");
        tr[i].style.display = "";
          
      }else{
           console.log(td.innerHTML);
        console.log("filtro alguma coisa");
        tr[i].style.display = "none";
      }
      
    }
  }
    
}

