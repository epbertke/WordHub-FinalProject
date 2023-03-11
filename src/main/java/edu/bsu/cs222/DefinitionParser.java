package edu.bsu.cs222;
import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public class DefinitionParser {
    private String definition;
    public DefinitionParser(InputStream json) throws IOException {
        this.definition = parseForDefinition(json);
    }
    public String fetchDefinition(){
        return this.definition;
    }

    private String parseForDefinition(InputStream jsonResponse) throws IOException {
        //we need to add error handling here
            //I would first try to go about handling it by :
        //adding a try/catch with the following code in the try block
        //adding if statement where an error is thrown if no definition is found
        //and if a definition IS found, then the method should return the definition
        //and the error should be caught in the catch, with error.getMessage() in the catch block body
            //the message should say something like "The word you have searched for is not found. Re-run the program and try again"
        JSONArray result = JsonPath.parse(jsonResponse).json();
        JSONArray jsonResultArray = JsonPath.read(result, "$..shortdef");
        String definition = jsonResultArray.get(0).toString();
        return definition;
    }

}
