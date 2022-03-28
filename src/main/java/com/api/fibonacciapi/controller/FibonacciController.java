package com.api.fibonacciapi.controller;

import com.api.fibonacciapi.domain.FibonacciNumber;
import com.api.fibonacciapi.exception.FibonacciIndexOutOfBoundsException;
import com.api.fibonacciapi.service.FibonacciService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/fibonacci")
public class FibonacciController {

    @Autowired
    private FibonacciService fibonacciService;

    @GetMapping("/sequence")
    @Operation(summary = "Return sequence",
            responses = {@ApiResponse(responseCode = "200",
                    description = "Sequence returned successfully",
                    content = @Content(schema = @Schema(implementation = FibonacciNumber.class)))})
    public List<Integer> fibonacciSequence(@RequestParam(required = false, defaultValue = "0") int start,
                                              @RequestParam(required = false, defaultValue = "75") int count) {
        List<Integer> sequence = fibonacciService.sequenceToN(start + count);
        return sequence.subList(start, sequence.size());

    }

    @GetMapping("/{fibonacciIndex}")
    @Operation(summary = "Return value",
            responses = {@ApiResponse(responseCode = "200",
                    description = "Value returned successfully",
                    content = @Content(schema = @Schema(implementation = FibonacciNumber.class)))})
    public FibonacciNumber calculateFibonacci(@PathVariable String fibonacciIndex) throws FibonacciIndexOutOfBoundsException {
        return fibonacciService.calculateFibonacci(Integer.parseInt(fibonacciIndex));
    }
}
