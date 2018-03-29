package com.laa.stepdefs;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import cucumber.api.Transformer;

public class LocalDateConverter extends Transformer<LocalDate>{

    @Override
    public LocalDate transform(String date) {

        //Not too sure about the date pattern though, check it out if it gives correct result
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        return LocalDate.parse(date, formatter); 
   }

}
