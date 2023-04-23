package com.tomholmes.products.library.repository;

import java.text.DecimalFormat;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.tomholmes.products.library.LibraryApplication;

@SpringBootTest(classes = LibraryApplication.class)
@Transactional
public class BaseDaoTest
{
    public DecimalFormat _df = new DecimalFormat("#.00");
}
