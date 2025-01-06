package com.satya.ecommerce_satya.controller;

import com.satya.ecommerce_satya.exception.ProductException;
import com.satya.ecommerce_satya.exception.UserException;
import com.satya.ecommerce_satya.model.Cart;
import com.satya.ecommerce_satya.model.User;
import com.satya.ecommerce_satya.request.AddItemRequest;
import com.satya.ecommerce_satya.response.ApiResponse;
import com.satya.ecommerce_satya.service.CartService;
import com.satya.ecommerce_satya.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
//@Tag(name="Cart Management",description="find uder cart,add item to cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @Autowired
    private UserService userService;

    @GetMapping("/")
//    @Operation(description="find cart by user id")
    public ResponseEntity<Cart> findUserCart(@RequestHeader("Authorization")String jwt) throws UserException{
        User user =userService.findUserprofileByJwt(jwt);
        Cart cart=cartService.findUserCart(user.getId());
        return new ResponseEntity<Cart>(cart, HttpStatus.OK);
    }
    @PutMapping("/add")
//    @Operation(description="add item to cart")
    public ResponseEntity<ApiResponse>addItemToCart(@RequestBody AddItemRequest req,
                                                    @RequestHeader("Authorization")String jwt)throws UserException, ProductException{
        User user=userService.findUserprofileByJwt(jwt);
        cartService.addCartItem(user.getId(),req);

        ApiResponse res=new ApiResponse();
        res.setMessage("item added to cart");
        res.setStatus(true);
        return new ResponseEntity<>(res,HttpStatus.OK);
    }
}
