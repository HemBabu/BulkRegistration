package com.Implementaiton;

import com.Controler.FileExporter;
import com.Model.Registration;

import java.io.IOException;
import java.io.Writer;

public class FileExporterImplementation implements FileExporter {

    @Override
    public void writeRegistration(Registration registration, Writer writer) throws IOException {
        if(registration.getGENDER().equals("M")){
            System.out.println("Mr. "+registration.getNAME()+ "your registration is done successfully ");
        }
        else {

            System.out.println("Mrs. "+registration.getNAME()+ "your registration is done successfully ");
        }
System.out.println();

            writer.write(registration.getMSISDN()+","+registration.getSIM_TYPE()+","+registration.getNAME()+","+registration.getDATE_OF_BIRTH()+","+registration.getGENDER()+","+registration.getADDRESS()+","+registration.getID_NUMBER()+","+"\n");

        }

    }

