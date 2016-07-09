package cn.gaoyuexiang.service;

import cn.gaoyuexiang.model.OnSaleInfo;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;

/**
 * Created by melo on 16-7-5.
 */
@Service
public class OnSaleService {

	public static final String ON_SALE_DB = "/onSale.json";
	private final SerializableService serializableService;

	@Autowired
	public OnSaleService(SerializableService serializableService) {
		this.serializableService = serializableService;
	}

	public List<OnSaleInfo> getSaleInfos() {
		InputStream onSaleStream = getClass().getResourceAsStream(ON_SALE_DB);
		return serializableService.convertTo(onSaleStream, new TypeReference<List<OnSaleInfo>>() {
		});
	}
}
