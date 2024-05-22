package br.com.fiap.pos.challenge.trips.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.pos.challenge.trips.config.response.ResponseBase;
import br.com.fiap.pos.challenge.trips.dto.ItineraryDTO;
import br.com.fiap.pos.challenge.trips.services.ItineraryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/itinerary")
@Tag(name = "Itinerary", description = "Endpoints for Create a new Itineraries")
public class ItineraryController {

    private final ItineraryService itineraryService;

    @Autowired
    public ItineraryController(final ItineraryService itineraryService) {
        this.itineraryService = itineraryService;
    }

    @PostMapping
    @Transactional
    @Operation(summary = "Add a new Itinerary", description = "Add a new Itinerary", tags = { "Itinerary" }, responses = {
            @ApiResponse(description = "Create", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ItineraryDTO.class))),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
    })
    public ResponseEntity<ResponseBase<ItineraryDTO>> createItinerary(
            @RequestBody final ItineraryDTO dto) {
        final var response = itineraryService.createItinerary(dto);
        final var base = ResponseBase.of(ItineraryDTO.of(response));
        return ResponseEntity.ok(base);
    }

}
