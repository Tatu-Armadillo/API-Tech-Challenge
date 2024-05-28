package br.com.fiap.pos.challenge.trips.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.pos.challenge.trips.config.response.ResponseBase;
import br.com.fiap.pos.challenge.trips.config.response.ResponseBasePagination;
import br.com.fiap.pos.challenge.trips.dto.traveler.SimpleTravelerDTO;
import br.com.fiap.pos.challenge.trips.dto.traveler.TravelerDTO;
import br.com.fiap.pos.challenge.trips.services.TravelerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/traveler")
@Tag(name = "Traveler", description = "Endpoints for Create a new Traveler")
public class TravelerController {

    private final TravelerService travelerService;

    @Autowired
    public TravelerController(final TravelerService travelerService) {
        this.travelerService = travelerService;
    }

    @PostMapping
    @Transactional
    @Operation(summary = "Add a new Traveler", description = "Add a new Traveler", tags = {
            "Traveler" }, responses = {
                    @ApiResponse(description = "Create", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TravelerDTO.class))),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            })
    public ResponseEntity<ResponseBase<TravelerDTO>> createTraveler(
            @RequestBody final TravelerDTO dto) {
        final var response = this.travelerService.createTraveler(dto);
        final var base = ResponseBase.of(TravelerDTO.of(response));
        return ResponseEntity.ok(base);
    }

    @GetMapping
    @Operation(summary = "Find Traveler with name filters", description = "responsible for returning the Traveler", tags = {
            "Traveler" }, responses = {
                    @ApiResponse(description = "Success", responseCode = "200", content = {
                            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = SimpleTravelerDTO.class))) }),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            })
    public ResponseEntity<ResponseBasePagination<List<SimpleTravelerDTO>>> findTravelersByName(
            final Pageable pageable,
            @RequestParam(required = false, defaultValue = "") final String travelerName) {
        final var response = this.travelerService.findTravelersByName(pageable, travelerName);
        final var base = ResponseBasePagination.of(response.map(SimpleTravelerDTO::of));
        return ResponseEntity.ok(base);
    }

}
