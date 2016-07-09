package cn.gaoyuexiang.service;

import cn.gaoyuexiang.exception.StorageException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

@Service
public class SerializableService {

	public <T> T SerializableService(InputStream itemsStream, TypeReference<T> typeRef) {
		ObjectMapper objMapper = new ObjectMapper();
		try {
			return objMapper.readValue(itemsStream, typeRef);
		} catch (IOException e) {
			throw new StorageException();
		}
	}
}
