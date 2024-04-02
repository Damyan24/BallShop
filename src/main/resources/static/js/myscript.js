const buttons = document.querySelectorAll('.add-to-basket');

const seeMore = document.querySelector(".button");

seeMore.addEventListener("click", function() {
    scrollBy(0, 1000);
});



buttons.forEach(button => {
    button.addEventListener('click', function() {
        
        const itemId = this.id;
        
      
        fetch("/cart/getUserId")
            .then(response => response.text())
            .then(userId => {
                console.log(itemId);
                console.log(userId);
                
               
               request = {
				   "userId" : userId,
				   "itemId" : itemId
			   }
                
                
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
