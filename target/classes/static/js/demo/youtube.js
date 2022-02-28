async function registrarUsuario() {
    
    let data = {};
    persona.name = $("#txtFirstName").val();
    persona.surname = $("#txtLastName").val();
    persona.email = $("#txtInputEmail").val();
    persona.phone = $("#txtInputPhone").val();
    persona.pass = $("#txtInputPassword").val();
  
    let repetirPassword = document.getElementById('txtRepetirPassword').value;
  
    if (repetirPassword != data.password) {
      alert('Passwords do not match!');
      return;
    }
  
    const request = await fetch('api/personas', {
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(data)
    });
    alert("Account created successfully!");
    window.location.href = 'login.html'
  
  }