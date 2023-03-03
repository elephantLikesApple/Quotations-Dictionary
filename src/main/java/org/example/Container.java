package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.build.controller.BuildController;
import org.example.quotation.entity.Quotation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Container {
    public static Scanner sc;
    private static String savedPath;
    private static List<Quotation> quotationList;
    private static ObjectMapper mapper;
    private static int index;
    public static void init() {
        sc = new Scanner(System.in);
        savedPath = "src\\quotation-dictionary.json";
        quotationList = new ArrayList<>();
        mapper = new ObjectMapper();
        index = 0;
    }

    public static void close() {
        sc.close();
    }

    public static Scanner getScanner() {
        return sc;
    }

    public static String getSavedPath() {
        return savedPath;
    }

    public static List<Quotation> getQuotationList() {
        return quotationList;
    }

    public static ObjectMapper getMapper() {
        return mapper;
    }

    public static int getIndex() {
        return index;
    }

    public static void setIndex(int index) {
        Container.index = index;
    }
}
