const addButton = document.querySelectorAll(".plus");
document.getele
const minusButton = document.querySelectorAll(".minus");

const removeButton = document.querySelectorAll(".remove");

const li = document.querySelectorAll(".li");

const total = document.querySelector(".total");

const quantities = document.querySelectorAll(".number")

const totalForEachRow = document.querySelectorAll(".totalItem");

const prices = document.querySelectorAll(".price");

const purchase = document.querySelector(".purchase")

removeButton.forEach(button => {
	button.addEventListener("click" , function (){
		const buttonId = this.id;

	fetch(`/cart/removeItem/?itemId=${buttonId}`)
	.then(response => response.text())
	.then(result => {
		if(result == "success"){
			
			
			li.forEach(l => {
  if (l.id == buttonId) { 
	  
	let price = 0;
	
	prices.forEach(p => {
		if(p.id = buttonId){
			price = p.innerHTML;
		}
	})	  
	
	const totalValue = total.innerHTML.replace("$" , "");
	
	const totalFloat = parseFloat(totalValue) - parseFloat(price);
	
	total.innerHTML = "$" + totalFloat.toFixed(2) ; 
	
    l.remove(); 

  }
});
		}
	})

	})
})





minusButton.forEach(button => {
button.addEventListener("click", function(){
		const buttonId = this.id;	
		
		quantities.forEach(q => {
			
			
			if(parseInt(q.innerHTML) > 1 && q.id == buttonId){
				q.innerHTML = parseInt(q.innerHTML) - 1;
				
				
				
				
				prices.forEach(p => {
					if(p.id == buttonId){
						
						const totalValue = total.innerHTML.replace("$" , "");
	
						const totalFloat = parseFloat(totalValue) - parseFloat(p.innerHTML);
	
						total.innerHTML = "$" + totalFloat.toFixed(2) ; 
						
						
						totalForEachRow.forEach(t =>{
							if(t.id == buttonId){
								t.innerHTML = parseFloat(t.innerHTML) - parseFloat(p.innerHTML)
								t.innerHTML = parseFloat(t.innerHTML).toFixed(2);
							}
						})
						
					}
				})
				
			}
			
			 
			    
			
		})
})
})



addButton.forEach(button => {
	button.addEventListener("click", function(){
		const buttonId = this.id;	
		
		quantities.forEach(q => {
			
			
			if(parseInt(q.innerHTML) < 10 && q.id == buttonId){
				q.innerHTML = parseInt(q.innerHTML) + 1;
				
				
				
				
				prices.forEach(p => {
					if(p.id == buttonId){
						
						const totalValue = total.innerHTML.replace("$" , "");
	
						const totalFloat = parseFloat(totalValue) + parseFloat(p.innerHTML);
	
						total.innerHTML = "$" + totalFloat.toFixed(2) ; 
						
						
						totalForEachRow.forEach(t =>{
							if(t.id == buttonId){
								t.innerHTML = parseFloat(t.innerHTML) + parseFloat(p.innerHTML);
								t.innerHTML = parseFloat(t.innerHTML).toFixed(2);
							}
						})
						
					}
				})
				
			}
			
			 
			    
			
		})
		
		
		
		
		
		
})
})







			
			
			
			
			purchase.addEventListener("click",function(){
	
	fetch("/cart/finalize").then(product => product.text()).then(result => {
		if(result == "success"){
			alert("Your purchase has been confirmed!")
			window.location.href = "/";
		}
	})
	
	
})