let cart = {}; // Key: dish name, Value: quantity

// Function to toggle cart visibility
function toggleCart() {
    const cartDiv = document.getElementById('cart');
    cartDiv.style.display = cartDiv.style.display === 'block' ? 'none' : 'block';

    // Update cart items
    updateCartItems();
}

// Function to update cart items in the cart div
function updateCartItems() {
    const cartItemsDiv = document.getElementById('cart-items');
    cartItemsDiv.innerHTML = ''; // Clear current items

    for (const dishName in cart) {
        const quantity = cart[dishName];

        const cartItemDiv = document.createElement('div');
        cartItemDiv.classList.add('cart-item');
        cartItemDiv.innerHTML = `
            <span>${dishName} (x${quantity})</span>
            <button onclick="removeFromCart('${dishName}')">Remove</button>
        `;
        cartItemsDiv.appendChild(cartItemDiv);
    }

    // Update cart count in the navigation
    document.getElementById('cart-count').textContent = Object.values(cart).reduce((a, b) => a + b, 0);
}

// Function to add dishes to the cart
function addToCart(dishName) {
    // Add or update dish quantity in the cart
    if (!cart[dishName]) {
        cart[dishName] = 0;
    }
    cart[dishName]++;

    updateCartItems();
}

// Function to remove item from the cart
function removeFromCart(dishName) {
    if (cart[dishName]) {
        delete cart[dishName];
        updateCartItems();
    }
}

function callout() {
           let name = document.querySelector('input[name="switch"]:checked').value;
                   document.getElementById("test").innerHTML = name;
          /* fetch("GreetUserServlet?name=" + encodeURIComponent(name))
               .then(response => response.text())
               .then(responseText => {
                   document.getElementById("greeting").innerHTML = responseText;
               })
               .catch(error => console.error("Error:", error));*/
       }

       function submitForm(){
            document.getElementById("myForm").submit();
       }