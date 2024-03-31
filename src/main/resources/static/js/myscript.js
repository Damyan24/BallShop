const buttons = document.querySelectorAll('.add-to-basket');

// Loop through each button and attach an event listener
buttons.forEach(button => {
    button.addEventListener('click', function() {
        // Retrieve the ID of the clicked button
        const itemId = this.id;
        
        // Fetch the user ID
        fetch("/cart/getUserId")
            .then(response => response.text())
            .then(userId => {
                console.log(itemId);
                console.log(userId);
                
                // Create the request object
               request = {
				   "userId" : userId,
				   "itemId" : itemId
			   }
                
                // Send the request to add the item to the cart
                fetch("/cart/addItem", {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/json"
                    },
                    body: JSON.stringify(request)
                })
                .then(response => response.text())
                .then(result => {
					if (result == "failure"){
						alert("Item is already in the basket!")
					}else{
						let itemCount = document.querySelector(".itemCount");
						itemCount.innerHTML = parseInt(itemCount.innerHTML) + 1;
						
						
	}
				});
            });
    });
});
