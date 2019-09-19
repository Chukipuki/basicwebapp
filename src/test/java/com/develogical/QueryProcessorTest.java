package com.develogical;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class QueryProcessorTest {

    QueryProcessor queryProcessor = new QueryProcessor();

    @Test
    public void returnsEmptyStringIfCannotProcessQuery() throws Exception {
        assertThat(queryProcessor.process("test"), is(""));
    }

    @Test
    public void knowsAboutShakespeare() throws Exception {
        assertThat(queryProcessor.process("Shakespeare"), containsString("playwright"));
    }

    @Test
    public void checkName() throws Exception {
        assertThat(queryProcessor.process("What is your name?"), containsString("superchu"));
    }

    @Test
    public void getLargest() throws Exception {
        assertThat(queryProcessor.process("a59a3c10: which of the following numbers is the largest: 378,81"), is("378") );
    }

    @Test
    public void isNotCaseSensitive() throws Exception {
        assertThat(queryProcessor.process("shakespeare"), containsString("playwright"));
    }

    @Test
    public void ifAddCorrectly() throws Exception {
        assertThat(queryProcessor.process("5757e270: what is 8 plus 8"), is("16"));
    }

    @Test
    public void ifMultipleCorrectly() throws Exception {
        assertThat(queryProcessor.process("62dc3430: what is 14 multiplied by 4"), is("56"));
    }

    @Test
    public void startJamesBond() throws Exception {
        assertThat(queryProcessor.process("159e0950: who played James Bond in the film Dr No"), containsString("Sean Connery"));
    }

    @Test
    public void isCubeAndSquare() throws Exception {
        assertThat(queryProcessor.process("5d429720: which of the following numbers is both a square and a cube: 225, 49, 2500, 550"), is(""));
    }

    @Test
    public void isParis() throws Exception {
        assertThat(queryProcessor.process("a4327740: which city is the Eiffel tower in"), containsString("Paris"));
    }



}
