package com.Controler;

import com.Implementaiton.FileExporterImplementation;
import com.Implementaiton.FileImporterImplementation;
import com.Model.Registration;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller extends RegistrationFileConverter{


static Map <String, ArrayList<String>> errorList=new HashMap<>();
    static String url = "src/com/Data/Registration.csv";
    static String outFilePath = "src/com/Data";
    static String outPutFleName = "MSISDN.txt";
    static String GENDER[]={"M","F"};
    ArrayList<String>listOfMSISDN=new ArrayList<>();
    List<Registration> invalidRegistration=new ArrayList<>();
    public static void main(String[] args) throws Exception {

        File file = new File(url);
Controller controller=new Controller();
controller.convert(file,outFilePath,outPutFleName);
        System.out.println("Invalid Registration!!!!!");
for(Registration r: controller.invalidRegistration){
    System.out.println(r);
}
        System.out.println("Invalid Registration Reason!!!!!");
Set<String>keys=new HashSet<>();
keys=errorList.keySet();
for(String key:keys)
{
    System.out.println(key+"Reason for Error"+errorList.get(key));
}
    }



    @Override
    protected FileExporter getRegisterExporter() {
        FileExporter fileExporter=new FileExporterImplementation();
        return  fileExporter;
    }

    @Override
    protected FileImporter getRegistrationImporter() {
        FileImporter fileimpl=new FileImporterImplementation();
        return fileimpl;

    }

    @Override
    protected List<Registration> getValidateRegistration(List<Registration> rawDataFile) throws Exception {

        for(Registration r:rawDataFile){
            listOfMSISDN.add(r.getMSISDN());
        }
        List<Registration> validateRegistration=new ArrayList<>();

for(Registration registration:rawDataFile){
    if(authentation(registration)){
        validateRegistration.add(registration);
    }
    else {
        invalidRegistration.add(registration);
    }

}
        return  validateRegistration;
    }

    private boolean authentation(Registration registration) throws Exception {
        int flag=0;
        boolean reult=false;
        ArrayList listError= new ArrayList();



        if(fieldEmpty(registration)){
            flag++;
            reult=false;
            listError.add("Empty Field Error");
        }
         if(isSpecialCharacter(registration.getNAME())){
             flag++;
            reult=false;
            listError.add("Special Character presence Error");
        }
        if(isInvalidDateOfBirth(registration.getDATE_OF_BIRTH())){
            flag++;
            reult=false;
            listError.add("Invalid Date of birth");
        }
        if(isInvalidGenderCheck(registration.getGENDER())){
            flag++;
            reult=false;
            listError.add("EInvalid Gender");
        }
        if(isInvalidAddress(registration.getADDRESS())){
            flag++;
            reult=false;
            listError.add("Invalid  Addressr");
        }
        if(isInvalidId(registration.getID_NUMBER())){
            flag++;
            reult=false;
            listError.add("Invalid Id");
        }
        if(isSimTypeInvalid(registration.getSIM_TYPE())){
            flag++;
            reult=false;
            listError.add("invalid Sim Type Error");
        }
        if(isMSISDNInvalid(registration.getMSISDN())){
            reult=false;
            flag++;
            listError.add("MSISDN Invalid Error");
        }
        if(isMSISDNDuplicate(registration.getMSISDN())){
            reult=false;
            flag++;
            listError.add("MSISDN Duplicate Error");
        }


        if(flag==0){
            return true;
        }
        else{
            errorList.put(registration.getMSISDN(),new ArrayList<>());
            errorList.put(registration.getMSISDN(),listError);
            return  reult;
        }

    }

    private boolean isMSISDNDuplicate(String msisdn) {
        int count=0;
        for(String s:listOfMSISDN){
            if(s.equals(msisdn)){
                count++;
            }
        }
        if(count>1){
            return true;
        }else return false;
    }

    private boolean isMSISDNInvalid(String msisdn) {
        if(msisdn.startsWith("+")||msisdn.startsWith("00")){//here I assumed MSISDN Number must start with + and 00
            return false;
        }
        else {
            return true;
        }
    }

    private boolean isSimTypeInvalid(String sim_type) {
        if(sim_type.equals("PREPAID")||sim_type.equals("POSTPAID")){
            return false;
        }
        else{
            return true;
        }
    }

    private boolean isInvalidId(String id_number) {
        int ic=0;
        int ac=0;
        for (int i = 0; i < id_number.length(); i++) {
            char c = id_number.charAt(i);
            if (!(c >= 'A' && c <= 'Z') &&
                    !(c >= 'a' && c <= 'z')) {
                ac++;

            } else if (!(c >= '0' && c <= '9')) {
                ic++;
            }
        }
        if(ac>1&&ic>1){

            return false;
        }
        else return true;


    }

    private boolean isInvalidAddress(String address) {
        if(address.length()>20){
            return false;
        }
        else {
            return true;
        }
    }

    private boolean isInvalidGenderCheck(String gender) {
        if(gender.equals("M")||gender.equals("F")){
            return false;
        }
        else{
            return true;
        }

    }

    private boolean isInvalidDateOfBirth(String dob) throws  Exception{
        boolean result=false;

        Date date=new Date();
        Date current=new Date();
       // LocalDate current = LocalDate.now();
        //current.getTime();

        SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");
        date=formatter1.parse(dob);
        //current=formatter1.parse()
        if(date.compareTo(current)<0){
            return false;
        }
        else {
            return true;
        }
        //return result;
    }

    private boolean isSpecialCharacter(String name) {
        Pattern p = Pattern.compile("[^A-Za-z0-9]");
        Matcher m = p.matcher(name);
        // boolean b = m.matches();
        boolean b = m.find();
        if (b){
            return true;
        }
        else{
            return false;
        }
    }

    private boolean fieldEmpty(Registration registration) {
        boolean result=false;

                if(registration.getMSISDN().equals(null)){
                    return true;
                }
                else if(registration.getSIM_TYPE().equals(null)){
                    return true;
                }
                else if(registration.getNAME().equals(null)){
                    return true;
                }
                else if(registration.getDATE_OF_BIRTH().equals(null)){
                    return true;

                }
                else if(registration.getGENDER().equals(null)){
                    return true;

                }
                else if (registration.getADDRESS().equals(null)){
                    return true;
                }
                else if(registration.getID_NUMBER().equals(null)){
                    return true;
                }
                else{
                    return false;
                }

                //return result;
    }

}
