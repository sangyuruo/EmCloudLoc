package com.emcloud.loc.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.emcloud.loc.domain.Address;
import com.emcloud.loc.domain.Area;

<<<<<<< HEAD
=======
import com.emcloud.loc.repository.AreaRepository;
>>>>>>> e40e538744d5e07c23ebcca0a5c3c0ee692ab526
import com.emcloud.loc.service.AreaService;
import com.emcloud.loc.web.rest.errors.BadRequestAlertException;
import com.emcloud.loc.web.rest.util.HeaderUtil;
import com.emcloud.loc.web.rest.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
<<<<<<< HEAD
import org.springframework.data.domain.Page;
=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
>>>>>>> e40e538744d5e07c23ebcca0a5c3c0ee692ab526
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.print.Pageable;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Area.
 */
@RestController
@RequestMapping("/api")
public class AreaResource {

    private final Logger log = LoggerFactory.getLogger(AreaResource.class);

    private static final String ENTITY_NAME = "area";

<<<<<<< HEAD
    private AreaService areaService;

    public AreaResource(AreaService areaService) {
        this.areaService = areaService;
    }
=======

    @Autowired
    private  AreaService areaService;

>>>>>>> e40e538744d5e07c23ebcca0a5c3c0ee692ab526

    /**
     * POST  /areas : Create a new area.
     *
     * @param area the area to create
     * @return the ResponseEntity with status 201 (Created) and with body the new area, or with status 400 (Bad Request) if the area has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/areas")
    @Timed
    public ResponseEntity<Area> createArea(@Valid @RequestBody Area area) throws URISyntaxException {
        log.debug("REST request to save Area : {}", area);
        if (area.getId() != null) {
            throw new BadRequestAlertException("A new area cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Area result = areaService.save(area);
        return ResponseEntity.created(new URI("/api/areas/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /areas : Updates an existing area.
     *
     * @param area the area to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated area,
     * or with status 400 (Bad Request) if the area is not valid,
     * or with status 500 (Internal Server Error) if the area couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/areas")
    @Timed
    public ResponseEntity<Area> updateArea(@Valid @RequestBody Area area) throws URISyntaxException {
        log.debug("REST request to update Area : {}", area);
        if (area.getId() == null) {
            return createArea(area);
        }
        Area result = areaService.save(area);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, area.getId().toString()))
            .body(result);
    }

    /**
     * GET  /areas : get all the areas.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of areas in body
     */
    @GetMapping("/areas")
    @Timed
<<<<<<< HEAD
    public ResponseEntity<List<Area>> getAllAreas(@ApiParam org.springframework.data.domain.Pageable pageable) {
=======
    public ResponseEntity<List<Area>> getAllAreas(@ApiParam Pageable pageable) {
>>>>>>> e40e538744d5e07c23ebcca0a5c3c0ee692ab526
        log.debug("REST request to get all Areas");
        Page<Area> page = areaService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/Areas");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }
<<<<<<< HEAD

=======
>>>>>>> e40e538744d5e07c23ebcca0a5c3c0ee692ab526

    /**
     * GET  /areas/:id : get the "id" area.
     *
     * @param id the id of the area to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the area, or with status 404 (Not Found)
     */
    @GetMapping("/areas/{id}")
    @Timed
    public ResponseEntity<Area> getArea(@PathVariable Long id) {
        log.debug("REST request to get Area : {}", id);
        Area area = areaService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(area));
    }

    /**
     * DELETE  /areas/:id : delete the "id" area.
     *
     * @param id the id of the area to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/areas/{id}")
    @Timed
    public ResponseEntity<Void> deleteArea(@PathVariable Long id) {
        log.debug("REST request to delete Area : {}", id);
        areaService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
