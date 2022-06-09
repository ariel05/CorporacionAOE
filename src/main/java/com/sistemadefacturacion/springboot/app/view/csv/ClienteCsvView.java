package com.sistemadefacturacion.springboot.app.view.csv;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;

@Component("listar")
public class ClienteCsvView extends AbstractView{

	
	
	@Override
	protected boolean generatesDownloadContent() {
		return true;
	}

	
	
	public ClienteCsvView() {
		setContentType("text/csv");
	}



	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		response.setHeader("Content-Disposition", "attachment; filename=\"clientes.csc\"");
		response.setContentType(getContentType());
	}

	
	
}
