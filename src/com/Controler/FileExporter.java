package com.Controler;

import com.Model.Registration;

import java.io.IOException;
import java.io.Writer;

public interface FileExporter {

    public void writeRegistration(Registration registration, Writer writer ) throws IOException;
}
