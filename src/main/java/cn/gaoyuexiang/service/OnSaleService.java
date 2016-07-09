package cn.gaoyuexiang.service;

import cn.gaoyuexiang.model.OnSaleMsg;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;

/**
 * Created by melo on 16-7-5.
 */
@Service
public class OnSaleService {

	public static final String ON_SALE_DB = "/onSale.json";

	public List<OnSaleMsg> loadMsg() {
		InputStream onSaleStream = getClass().getResourceAsStream(ON_SALE_DB);
//		return new SerializableService().convertTo(onSaleStream, OnSaleMsg.class);
		return new SerializableService().convertTo(onSaleStream, new TypeReference<List<OnSaleMsg>>() {
		});
	}
}
