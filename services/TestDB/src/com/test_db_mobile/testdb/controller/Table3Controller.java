/*Copyright (c) 2015-2016 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/

package com.test_db_mobile.testdb.controller; 

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import com.test_db_mobile.testdb.service.Table3Service;


import java.io.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.hibernate.TypeMismatchException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.util.WMMultipartUtils;
import com.wavemaker.runtime.util.WMRuntimeUtils;
import com.wordnik.swagger.annotations.*;

import com.test_db_mobile.testdb.*;
import com.test_db_mobile.testdb.service.*;


/**
 * Controller object for domain model class Table3.
 * @see com.test_db_mobile.testdb.Table3
 */

@RestController(value = "TestDB.Table3Controller")
@Api(value = "/TestDB/Table3", description = "Exposes APIs to work with Table3 resource.")
@RequestMapping("/TestDB/Table3")
public class Table3Controller {

    private static final Logger LOGGER = LoggerFactory.getLogger(Table3Controller.class);

	@Autowired
	@Qualifier("TestDB.Table3Service")
	private Table3Service table3Service;


	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ApiOperation(value = "Returns the list of Table3 instances matching the search criteria.")
	public Page<Table3> findTable3s( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
		LOGGER.debug("Rendering Table3s list");
		return table3Service.findAll(queryFilters, pageable);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the list of Table3 instances.")
	public Page<Table3> getTable3s(Pageable pageable) {
		LOGGER.debug("Rendering Table3s list");
		return table3Service.findAll(pageable);
	}

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the total count of Table3 instances.")
	public Long countAllTable3s() {
		LOGGER.debug("counting Table3s");
		Long count = table3Service.countAll();
		return count;
	}


    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the Table3 instance associated with the given id.")
    public Table3 getTable3(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting Table3 with id: {}" , id);
        Table3 instance = table3Service.findById(id);
        LOGGER.debug("Table3 details with id: {}" , instance);
        return instance;
    }
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deletes the Table3 instance associated with the given id.")
    public boolean deleteTable3(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Table3 with id: {}" , id);
        Table3 deleted = table3Service.delete(id);
        return deleted != null;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @ApiOperation(value = "Updates the Table3 instance associated with the given id.")
    public Table3 editTable3(@PathVariable("id") Integer id, @RequestBody Table3 instance) throws EntityNotFoundException {
        LOGGER.debug("Editing Table3 with id: {}" , instance.getId());
        instance.setId(id);
        instance = table3Service.update(instance);
        LOGGER.debug("Table3 details with id: {}" , instance);
        return instance;
    }




	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ApiOperation(value = "Creates a new Table3 instance.")
	public Table3 createTable3(@RequestBody Table3 instance) {
		LOGGER.debug("Create Table3 with information: {}" , instance);
		instance = table3Service.create(instance);
		LOGGER.debug("Created Table3 with information: {}" , instance);
	    return instance;
	}

	/**
	 * This setter method should only be used by unit tests
	 * 
	 * @param service
	 */
	protected void setTable3Service(Table3Service service) {
		this.table3Service = service;
	}
}

