package br.com.busolli.lorenzo.patterns1.loja.http;

import java.util.Map;

public interface HttpAdapter {

	void post(String url, Map<String, Object> dados);

}
