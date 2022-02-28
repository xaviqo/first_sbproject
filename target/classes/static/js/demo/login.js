async function logIn() {

    let persona = {};
    persona.email = $("#txtInputEmail").val();
    persona.password = $("#txtInputPassword").val();

    const request = await fetch('api/login', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(persona)
    });

    const response = await request.text();

    if (response != 'FAIL'){
        localStorage.token = response;
        localStorage.email = persona.email;
        window.location.href = "tables.html";
    } else {
        alert('Wrong email or password');
    }
}