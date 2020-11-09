
package com.automationanywhere.botcommand.sk;



import static com.automationanywhere.commandsdk.model.AttributeType.TEXT;
import static com.automationanywhere.commandsdk.model.DataType.STRING;

import com.automationanywhere.botcommand.data.impl.DictionaryValue;
import com.automationanywhere.commandsdk.annotations.BotCommand;
import com.automationanywhere.commandsdk.annotations.CommandPkg;
import com.automationanywhere.commandsdk.annotations.Idx;
import com.automationanywhere.commandsdk.annotations.Pkg;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;
import com.automationanywhere.commandsdk.model.DataType;
import com.automationanywhere.commandsdk.annotations.Execute;


/**
 * @author Stefan Karsten
 *
 */

@BotCommand
@CommandPkg(label = "JSON to Dictionary", name = "jsontodict",
        description = "Converts a JSON string to a Dictionary",
        node_label = "JSON to Dictionary", icon = "pkg.svg", comment = true ,  text_color = "#76aea8" , background_color =  "#76aea8" ,
        return_type=DataType.DICTIONARY, return_label="Dictionary", return_required=true)
public class JSONtoDictionary {
	   
	@Execute
    public DictionaryValue  action(@Idx(index = "1", type = TEXT)  @Pkg(label = "JSON String" , default_value_type = STRING) @NotEmpty String jsonstring
                                      ) throws Exception
     {

		JSONUtils parser = new JSONUtils();
		
		DictionaryValue map = parser.parseJSON(jsonstring);
		
		return map;
	}

		
	
}