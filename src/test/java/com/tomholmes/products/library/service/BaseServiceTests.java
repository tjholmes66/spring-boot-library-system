package com.tomholmes.products.library.service;

import java.text.DecimalFormat;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import com.tomholmes.products.library.LibraryApplication;

@SpringBootTest(classes = LibraryApplication.class)
@Transactional
public class BaseServiceTests
{
    public DecimalFormat _df = new DecimalFormat("#.00");

    public static final ObjectMapper makeMapper()
    {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new ParameterNamesModule());
        mapper.registerModule(new Jdk8Module());
        mapper.registerModule(new JavaTimeModule());
        return mapper;
    }

}
