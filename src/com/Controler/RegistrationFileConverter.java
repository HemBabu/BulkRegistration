package com.Controler;

import com.Model.Registration;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.List;
import java.util.Map;

public abstract class RegistrationFileConverter {

    protected abstract FileExporter getRegisterExporter();

    protected abstract FileImporter getRegistrationImporter();

    protected abstract List<Registration> getValidateRegistration(List<Registration> membersFromFile) throws Exception;


    public void convert(File inputMemberFile, String outputFilePath, String outputFileName) throws Exception {
        FileImporter memberImporter = getRegistrationImporter();

        List<Registration> membersFromFile = memberImporter.importFile(inputMemberFile);

        FileExporter exporter= getRegisterExporter();
        List<Registration> validRegistration = getValidateRegistration(membersFromFile);
String fullDirectory=outputFilePath+"/"+outputFileName;
        System.out.println("FULL DIREC:::"+fullDirectory);
        Writer writer = new FileWriter(fullDirectory);

        for (Registration registration : validRegistration) {
            exporter.writeRegistration(registration, writer);
        }

        writer.flush();
        writer.close();

        }




    }



