
package com.automationanywhere.botcommand.sk;



import static com.automationanywhere.commandsdk.model.AttributeType.TEXT;
import static com.automationanywhere.commandsdk.model.DataType.STRING;

import org.json.JSONObject;

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
@CommandPkg(label = "JSON Item to Dictionary", name = "jsonitemtodict",
        description = "Get Item in a JSON string and converts it to a Dictionary",
        node_label = "JSON Item to Dictionary", icon = "pkg.svg", comment = true ,  text_color = "#76aea8" , background_color =  "#76aea8" ,
        return_type=DataType.DICTIONARY, return_label="Dictionary", return_required=true)
public class GetItem {
	   
	@Execute
    public DictionaryValue  action(@Idx(index = "1", type = TEXT)  @Pkg(label = "JSON String" , default_value_type = STRING) @NotEmpty String jsonstring,
    							   @Idx(index = "2", type = TEXT)  @Pkg(label = "Query" , description = "Query in the format x.y  to get item y", default_value_type = STRING) @NotEmpty String query  
    							   )throws Exception
     {
		
		JSONUtils parser = new JSONUtils();
		
		DictionaryValue map = parser.queryJSON(jsonstring, query);
		
		return map;
	}

		
	
}