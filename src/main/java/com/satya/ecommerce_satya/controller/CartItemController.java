package com.satya.ecommerce_satya.controller;

import com.satya.ecommerce_satya.exception.CartItemException;
import com.satya.ecommerce_satya.exception.UserException;
import com.satya.ecommerce_satya.model.CartItem;
import com.satya.ecommerce_satya.model.User;
import com.satya.ecommerce_satya.response.ApiResponse;
import com.satya.ecommerce_satya.service.CartItemService;
import com.satya.ecommerce_satya.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart_items")
public class CartItemController {
    @Autowired
    private CartItemService cartItemService;
    @Autowired
    private UserService userService;

    @DeleteMapping("/{cartItemId}")
//    @Operation(description="Remove CartItem From Cart")
//    @io.swagger.v3.oas.annotation.responses.ApiResponse(description="Delete Item")
    public ResponseEntity<ApiResponse> deleteCartItem(@PathVariable Long cartItemId,
                                                      @RequestHeader("Authorization")String jwt)throws UserException, CartItemException{
        User user=userService.findUserprofileByJwt(jwt);
        cartItemService.removeCartItem(user.getId(),cartItemId);

        ApiResponse res=new ApiResponse();
        res.setMessage("item removed from cart");
        res.setStatus(true);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    @PutMapping("/{cartItemId}")
//    @Operation(description="Update item TO Cart")
    public ResponseEntity<CartItem>updateCartItem(
            @RequestBody CartItem cartItem,
            @PathVariable Long cartItemid,
            @RequestHeader("Authorization")String jwt)throws UserException, CartItemException {
        User user=userService.findUserprofileByJwt(jwt);
        CartItem updateCartItem= cartItemService.updateCartItem(user.getId(),cartItemid,cartItem);


        return new ResponseEntity<>(updateCartItem,HttpStatus.CREATED);
    }

}
