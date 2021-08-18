package com.Implementaiton;

import com.Controler.FileImporter;
import com.Model.Registration;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class FileImporterImplementation implements FileImporter {


    @Override
    public List<Registration> importFile(File inputFile) throws Exception {



        List<Registration> rawRegistration =new ArrayList<Registration>();
        BufferedReader br = new BufferedReader(new FileReader(inputFile));
        String line =br.readLine();
        try {
            while (!(line =br.readLine()).equals(null)) {
                Registration registration = new Registration();
                //System.out.println(line);


                String[] listAttribute = new String[0];
                listAttribute=line.split(",");
                registration.setMSISDN(listAttribute[0]);
                registration.setSIM_TYPE(listAttribute[1]);
                registration.setNAME(listAttribute[2]);
                registration.setDATE_OF_BIRTH(listAttribute[3]);
                registration.setGENDER(listAttribute[4]);
                registration.setADDRESS(listAttribute[5]);
                registration.setID_NUMBER(listAttribute[6]);
                rawRegistration.add(registration);
               // System.out.println(registration);
            }
        } catch (NullPointerException npe) {
            System.out.println("Null pointer exception" +
                    "");
            // Define what needs to be done when an NPE is caught
        }

br.close();

        return rawRegistration;

    }
}
