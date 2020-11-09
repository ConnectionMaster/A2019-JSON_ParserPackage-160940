
package com.automationanywhere.botcommand.sk;



import static com.automationanywhere.commandsdk.model.AttributeType.TEXT;
import static com.automationanywhere.commandsdk.model.DataType.STRING;

import java.util.Map;

import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.data.impl.DictionaryValue;
import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.commandsdk.annotations.BotCommand;
import com.automationanywhere.commandsdk.annotations.CommandPkg;
import com.automationanywhere.commandsdk.annotations.Idx;
import com.automationanywhere.commandsdk.annotations.Pkg;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;
import com.automationanywhere.commandsdk.model.AttributeType;
import com.automationanywhere.commandsdk.model.DataType;
import com.automationanywhere.toolchain.runtime.variable.Variable;
import com.automationanywhere.commandsdk.annotations.Execute;


/**
 * @author Stefan Karsten
 *
 */

@BotCommand
@CommandPkg(label = "Dictionary to JSON", name = "dicttojson",
        description = "Converts a Dictionary to a JSON string",
        node_label = "Dictionary to JSON", icon = "pkg.svg", comment = true ,  text_color = "#76aea8" , background_color =  "#76aea8" ,
        return_type=DataType.STRING, return_label="JSON String", return_required=true)
public class DictionarytoJSON {
	   
	@Execute
    public StringValue  action(@Idx(index = "1", type = AttributeType.VARIABLE )  @Pkg(label = "Dictionary with key/value pairs"  , default_value_type = DataType.DICTIONARY ) @NotEmpty Map<String,Value> inputdict
                                      ) throws Exception
     {

		JSONUtils parser = new JSONUtils();
		
		String jsonstring = parser.toJSON(inputdict);
		
	
		
		return new StringValue(jsonstring);

	}

		
	
}