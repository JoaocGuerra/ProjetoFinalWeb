function valida() {
    var senha = document.getElementById("password").value();
    alert(senha);
    let regex = /^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%*()_+^&}{:;?.])(?:([0-9a-zA-Z!@#$%;*(){}_+^&])(?!\1)){6,}$/;
    if (regex.test(senha)) {
        console.log(senha, '= válida');
    } else {
        console.log(senha, '= inválida');
    }
}