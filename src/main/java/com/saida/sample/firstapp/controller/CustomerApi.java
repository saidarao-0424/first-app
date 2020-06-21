package com.saida.sample.firstapp.controller;

import com.saida.sample.firstapp.model.Customer;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/customers")
@Tag(name = "Customer API", description = "the Customer API")
public interface CustomerApi {

    @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Creates Customer with given body")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Customer Created successfully",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Customer.class))})})
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) ;


    @PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Updates Customer with given body")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Customer Updated successfully",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Customer.class))})})
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) ;
    @DeleteMapping(path = "/delete/{id}")
    @Operation(summary = "Deletes Customer with given id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Customer Deleted successfully",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Customer.class))})})
    public ResponseEntity<Void> deleteCustomer(@PathVariable Integer id);

    @GetMapping(path = "/find/{id}")
    @Operation(summary = "Get a book by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the Customer",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Customer.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Customer not found",
                    content = @Content)})
    public Customer getCustomer(@PathVariable Integer id) ;

    @GetMapping(path = "/list")
    @Operation(summary = "List all Customers")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = Customer.class))))})
    public ResponseEntity<List<Customer>> listCustomer();

}
