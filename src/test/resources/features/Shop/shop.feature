Feature: As Customer I would To get Pets with status Filter , Create Update and Delete New Pet 

  @PostPetwithfiledata
  Scenario Outline: Get Pets with Filter Param, Create Pet from Json File, Update Pet Param and Delete Created Pet
   Given User Go to HomePage 
   And User Navigate through Product categories "<Listitems>"
   And User Navigate to Product category "<item>" "<product>"
   And User Click on "<label>" 
   And User Accept Popup confirmation 
   And User Go to HomePage 
   And User Navigate to Product category "<item2>" "<product2>"
   And User Click on "<label>" 
   And User Accept Popup confirmation  
   And User Click on "<menuname>" menu
   And User Delete "<product2>" from Cart
   When User Click on Place order
   And User FulfillForm with "<data>"
   And Amount displayed on Form is Correct
   And User Click on Purchase
   Then Amount is equal to expected
    Examples: 
    | Listitems               |item    |product     |label        |label2  |item2     |product2       |pathcart|menuname|data|
    | Phones,Laptops,Monitors |Laptops |Sony vaio i5|Add to cart  |label2  |Laptops |Dell i7 8gb    |cart.html |Cart   |name=Nesrine,country=france,city=Paris,card=123456789,month=11,year=2022|