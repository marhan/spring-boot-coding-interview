package de.marhan.coding.interview.fizzbuzz;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/fizzbuzz", produces = MediaType.APPLICATION_JSON_VALUE)
public class FizzBuzzRestController {

    private final FizzBuzzService service;

    @GetMapping("/{number}")
    @Operation(description = "Returns the FizzBuzz representation")
    public ResponseEntity<FizzBuzzResource> calculateOutput(@PathVariable("number") Integer number) {
        String output = service.calculate(number);
        return ResponseEntity.ok(FizzBuzzResource.builder().id(number).output(output).build());
    }
}
