package de.marhan.coding.interview.fizzbuzz;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FizzBuzzResource {
    private Integer id;
    private String output;
}
