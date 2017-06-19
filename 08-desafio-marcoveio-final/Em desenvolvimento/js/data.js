function buscarData(){
var hoje = new Date();
var ano = hoje.getFullYear();
var dia = hoje.getDate();
var mes = hoje.getMonth();
var meses = ["Janeiro","Fevereiro","Março","Abril","Maio","Junho","Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"];
var mes = meses[mes];
document.write(mes+" "+dia+", "+ano);
}
window.onload = buscarData();