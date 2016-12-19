package com.yike.json;

import java.util.List;

import com.yike.getServerMessages.Content;
import com.yike.getServerMessages.MessageFilter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonOperation {
	public String tojson(String datatype){
		ObjectMapper mapper = new ObjectMapper();
		MessageFilter mf = new MessageFilter();
       //JsonGenerator generator = mapper.getJsonFactory().createJsonGenerator(System.out,JsonEncoding.UTF8);
		try {
			if(datatype.equals("agentstatus")){
				List<Content> contents = mf.GetChannels();
				for(Content content:contents){
					String fullname = content.getRegname();
					content.setRegname(fullname.substring(0, fullname.indexOf("@")));
				}
				//System.out.println(mapper.writeValueAsString(contents));
				return mapper.writeValueAsString(contents);
			}else if(datatype.equals("conference_id")){
				
			}
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return null;
	}
}
