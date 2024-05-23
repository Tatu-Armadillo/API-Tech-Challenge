package br.com.fiap.pos.challenge.trips.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.pos.challenge.trips.config.response.ResponseBase;
import br.com.fiap.pos.challenge.trips.config.response.ResponseBasePagination;
import br.com.fiap.pos.challenge.trips.dto.itinerary.ItineraryDTO;
import br.com.fiap.pos.challenge.trips.dto.itinerary.SimpleListitineraryDTO;
import br.com.fiap.pos.challenge.trips.services.ItineraryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
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

        @GetMapping
        @Operation(summary = "Find Itineraries with filters", description = "responsible for returning the itineraries", tags = {
                        "Itinerary" }, responses = {
                                        @ApiResponse(description = "Success", responseCode = "200", content = {
                                                        @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = SimpleListitineraryDTO.class))) }),
                                        @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                                        @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                                        @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
                        })
        public ResponseEntity<ResponseBasePagination<List<SimpleListitineraryDTO>>> pageItinerariesWithFilter(
                        @PageableDefault(sort = "crateDate", direction = Direction.DESC) final Pageable pageable,
                        @RequestParam(required = false, defaultValue = "") final String filter) {
                final var response = this.itineraryService.pageItinerariesWithFilter(pageable, filter);
                final var base = ResponseBasePagination.of(response.map(SimpleListitineraryDTO::of));
                return ResponseEntity.ok(base);
        }

        @GetMapping("/{id}")
        @Operation(summary = "Open Itinerary for ID", description = "responsible for returning Itinerary for ID", tags = {
                        "Itinerary" }, responses = {
                                        @ApiResponse(description = "Success", responseCode = "200", content = {
                                                        @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ItineraryDTO.class))) }),
                                        @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                                        @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                                        @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
                        })
        public ResponseEntity<ResponseBase<ItineraryDTO>> findById(@PathVariable final Long id) {
                final var response = this.itineraryService.findById(id);
                final var base = ResponseBase.of(ItineraryDTO.of(response));
                return ResponseEntity.ok(base);
        }

        @PostMapping
        @Transactional
        @Operation(summary = "Add a new Itinerary", description = "Add a new Itinerary", tags = {
                        "Itinerary" }, responses = {
                                        @ApiResponse(description = "Create", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ItineraryDTO.class))),
                                        @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                                        @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                                        @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
                        })
        public ResponseEntity<ResponseBase<ItineraryDTO>> createItinerary(
                        @RequestBody final ItineraryDTO dto) {
                final var response = this.itineraryService.createItinerary(dto);
                final var base = ResponseBase.of(ItineraryDTO.of(response));
                return ResponseEntity.ok(base);
        }

}
