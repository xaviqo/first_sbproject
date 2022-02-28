async function createPersona() {

    let persona = {};
    persona.name = $("#txtFirstName").val();
    persona.surname = $("#txtLastName").val();
    persona.email = $("#txtInputEmail").val();
    persona.phone = $("#txtInputPhone").val();
    persona.password = $("#txtInputPassword").val();

    let repeatPassword = $("#txtRepeatPassword").val();

    if (repeatPassword != persona.password) {
        alert("Passwords do not match!");
        return;
    }

    const request = await fetch('api/personas', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(persona)
    });


}