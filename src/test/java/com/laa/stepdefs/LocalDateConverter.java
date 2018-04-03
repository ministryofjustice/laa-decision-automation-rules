package com.laa.stepdefs;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import cucumber.deps.com.thoughtworks.xstream.converters.Converter;
import cucumber.deps.com.thoughtworks.xstream.converters.MarshallingContext;
import cucumber.deps.com.thoughtworks.xstream.converters.UnmarshallingContext;
import cucumber.deps.com.thoughtworks.xstream.io.HierarchicalStreamReader;
import cucumber.deps.com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class LocalDateConverter implements Converter {

	private static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";
	private static final DateTimeFormatter DEFAULT_DATE_FORMATTER = DateTimeFormatter.ofPattern(DEFAULT_DATE_PATTERN);

	public boolean canConvert(Class type) {
		// return type.equals(LocalDate.class);
		return LocalDate.class.isAssignableFrom(type);
	}

	public void marshal(Object value, HierarchicalStreamWriter writer, MarshallingContext context) {
		LocalDate date = (LocalDate) value;
		String result = date.format(DEFAULT_DATE_FORMATTER);
		writer.setValue(result);
	}

	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
		LocalDate result = LocalDate.parse(reader.getValue(), DEFAULT_DATE_FORMATTER);
		return result;
	}

}
