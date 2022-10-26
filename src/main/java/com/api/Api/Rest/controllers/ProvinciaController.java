package com.api.Api.Rest.controllers;

import com.api.Api.Rest.entities.Provincia;
import com.api.Api.Rest.services.ProvinciaServiceImpl;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/provincias")
public class ProvinciaController extends BaseControllerImpl<Provincia, ProvinciaServiceImpl>{

}
