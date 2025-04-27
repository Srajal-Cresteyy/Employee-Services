package com.srajaldwivedi.employee.controller;

import com.srajaldwivedi.employee.dto.EmployeeDetailsDto;
import com.srajaldwivedi.employee.dto.ErrorResponseDto;
import com.srajaldwivedi.employee.service.IEmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Pattern;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Tag(
        name = "REST API for Employee",
        description = "REST APIs in EazyBank to FETCH customer details"
)
@RestController
@RequestMapping(path="/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class EmployeeController {

    private final IEmployeeService iEmployeeService;

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    public EmployeeController(IEmployeeService iEmployeeService){
        this.iEmployeeService = iEmployeeService;
    }

    @Operation(
            summary = "Fetch Employee Details REST API",
            description = "REST API to fetch Employee details based on a mobile number"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )
    @GetMapping("/fetchEmployeeDetails")
    public ResponseEntity<EmployeeDetailsDto> fetchCustomerDetails(@RequestHeader("EmployeeApp-correlation-id") String correlationId,
                                                                   @RequestParam @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits")
                                                                   String mobileNumber){
        logger.debug("fetchEmployeeDetails Method Start");
        EmployeeDetailsDto employeeDetailsDto = iEmployeeService.fetchCustomerDetails(mobileNumber,correlationId);
        logger.debug("fetchEmployeeDetails Method End");
        return ResponseEntity.status(HttpStatus.SC_OK).body(employeeDetailsDto);

    }


}
