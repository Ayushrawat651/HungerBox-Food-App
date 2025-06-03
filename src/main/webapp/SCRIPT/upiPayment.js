 // Validate the UPI ID format

 function validateUpiId(upiId) {

    const upiRegex = /^[a-zA-Z0-9.\-_]{2,}@[a-zA-Z]{2,}$/;

    return upiRegex.test(upiId);

  }



  function processPayment() {
     //event.preventDefault();
    const upiId = document.getElementById('upi-id').value.trim();

    const successMessage = document.getElementById('success-message');

    const warmMessage = document.getElementById('warm-message');

    const errorMessage = document.getElementById('error-message');

    const userId = document.getElementById('user-id');



    // Hide previous messages

    successMessage.style.display = 'none';

    warmMessage.style.display = 'none';

    errorMessage.style.display = 'none';

    userId.style.display = 'none';



    // Validate input

    if (!upiId) {

      alert('Please enter your UPI ID.');

      return false;

    }



    if (!validateUpiId(upiId)) {

      errorMessage.style.display = 'block';

      return false;

    }



    // Generate a random 6-digit User ID

    const randomUserId = Math.floor(100000 + Math.random() * 900000);



    // Simulate successful payment

    setTimeout(() => {

      successMessage.style.display = 'block';

      successMessage.innerText = 'Payment Successful! Please Collect your order!!';

      warmMessage.style.display = 'block';

      warmMessage.innerText = 'Thank you for using Hungerbox! We hope to serve you again soon.';

      userId.style.display = 'block';

      userId.innerText = `Your Order ID: ${randomUserId}`;
      return true;
    }, 500);

    return true;

  }
