var controle5 = document.querySelector('.favoritando');
controle5.onclick = function() {
  if (controle5.className == 'favoritando') {
    controle5.className = 'favorita';
  } else {
    controle5.className = 'favoritando';
  }
  return false;
};