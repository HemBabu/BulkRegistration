package com.Controler;

import com.Model.Registration;

import java.io.File;
import java.util.List;

public interface FileImporter {
    public List<Registration> importFile(File inputFile ) throws Exception;
}
