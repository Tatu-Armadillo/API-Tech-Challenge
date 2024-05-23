package br.com.fiap.pos.challenge.trips.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.pos.challenge.trips.config.response.ResponseBasePagination;
import br.com.fiap.pos.challenge.trips.dto.DestinatioDTO;
import br.com.fiap.pos.challenge.trips.services.DestinationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/destinations")
@Tag(name = "Destinations", description = "Endpoints for find Destinations")
public class DestinationController {

        private final DestinationService cityService;

        @Autowired
        public DestinationController(final DestinationService cityService) {
                this.cityService = cityService;
        }

        @GetMapping
        @Operation(summary = "Find destinations with filters", description = "responsible for returning destinations", tags = {
                        "Destinations" }, responses = {
                                        @ApiResponse(description = "Success", responseCode = "200", content = {
                                                        @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = DestinatioDTO.class))) }),
                                        @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                                        @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                                        @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
                        })
        public ResponseEntity<ResponseBasePagination<List<DestinatioDTO>>> pageDestinationsWithFilter(
                        @PageableDefault(sort = "name", direction = Direction.ASC) final Pageable pageable,
                        @RequestParam(required = false, defaultValue = "") final String filter) {
                final var response = this.cityService.pageDestinationsWithFilter(pageable, filter);
                final var base = ResponseBasePagination.of(response.map(DestinatioDTO::of));
                return ResponseEntity.ok(base);
        }

}
