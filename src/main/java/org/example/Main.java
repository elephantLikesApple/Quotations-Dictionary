package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.quotation.entity.Quotation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Container.init();
        App.run();
        Container.close();
    }


}