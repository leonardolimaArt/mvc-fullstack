/**
 * 
 */
function alertDelLix(idcon, nome) {
	var resposta = confirm("Quer mesmo excluir este contato?")
	if (resposta == true) {
		alert("O contato " + nome + " foi enviado para a Lixeira!")
		window.location.href = "lixeira?idcon=" + idcon
	}
}

function alertDelDef(idcon, nome) {
	var resposta = confirm("Quer mesmo excluir definitivamente este contato?")
	if (resposta == true) {
		alert("O contato " + nome + " foi excluido definitivamente!")
		window.location.href = "deletedef?idcon=" + idcon
	}
}

function alertDelAll() {
	var resposta = confirm("Quer mesmo excluir definitivamente todos os contatos?")
	if (resposta == true) {
		alert("Os contatos foram excluidos definitivamente!")
		window.location.href = "delall"
	}
}

function validSenha(){
	
	var senha = document.getElementById('senha').value;

	var letr = /[A-Z]/g;
	var numer = /\d+/g;
	var espec = /[ `!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?~]/g;
	
	var check1 = 0;
	var check2 = 0;
	var check3 = 0;
		
	if(senha.match(letr)){
		document.getElementById('c0').innerHTML = "✅ Uma letra maiúscula.";
		check1 = 1;
	}else{
		document.getElementById('c0').innerHTML = "❌ Uma letra maiúscula.";
		check1 = 0;
	}
	
	if(senha.match(numer)){
		document.getElementById('c1').innerHTML = "✅ Um número.";
		check2 = 1;
	}else{
		document.getElementById('c1').innerHTML = "❌ Um número.";
		check2 = 0;
	}
	if(senha.match(espec)){
		document.getElementById('c2').innerHTML = "✅ Um caracter especial.";
		check3 = 1;
	}else{
		document.getElementById('c2').innerHTML = "❌ Um caracter especial.";
		check3 = 0;
	}
	
	if(check1 == 1 && check2 == 1 && check3 == 1){
		document.getElementById("subutton").disabled = false;
		document.getElementById("subutton").style.background='#2e57cb';
	}else{
		document.getElementById("subutton").disabled = true;
		document.getElementById("subutton").style.background='rgb(192,192,192)';
	}

}