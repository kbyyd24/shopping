package cn.gaoyuexiang.service;

import cn.gaoyuexiang.model.OnSaleMsg;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by melo on 16-7-5.
 */
@Service
public class OnSaleService {
	public List<OnSaleMsg> loadMsg() {
		InputStream onSaleStream = getClass().getResourceAsStream("/onSale.json");
		ArrayList<OnSaleMsg> msgs = new ArrayList<>();
		try {
			ObjectMapper mapper = new ObjectMapper();
			JsonNode onSaleNodes = mapper.readTree(onSaleStream);
			for (JsonNode onSaleNode : onSaleNodes) {
				OnSaleMsg onSaleMsg = mapper.readValue(onSaleNode.toString(), OnSaleMsg.class);
				msgs.add(onSaleMsg);
			}
			onSaleStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return msgs;
	}
}
