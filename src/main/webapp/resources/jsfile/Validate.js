
 function validateName()
           { 
        	var name=document.getElementById("n").value;
           var pattern=/^[A-Za-z]+$/; //ab9
           var result=name.match(pattern);
           if(result==null)
           { document.getElementById("p").innerHTML="only char allow";
           }
           else
           {
           document.getElementById("p").innerHTML="";
           }

           }


           function validateContact()
         { 
         var contact=document.getElementById("c").value;
         var pattern=/^[0-9]+$/; //ab
          var result=contact.match(pattern);
           if(contact.length!=10)
           {
			    document.getElementById("s").innerHTML="invalid contact";
		   }
               
              else
               {
                document.getElementById("s").innerHTML="";
               }

            }
           
