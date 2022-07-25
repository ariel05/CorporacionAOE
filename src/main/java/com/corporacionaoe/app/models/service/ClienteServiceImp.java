package com.corporacionaoe.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.corporacionaoe.app.models.dao.IClienteDao;
import com.corporacionaoe.app.models.dao.IFacturaDao;
import com.corporacionaoe.app.models.dao.IProductoDao;
import com.corporacionaoe.app.models.entity.Cliente;
import com.corporacionaoe.app.models.entity.Factura;
import com.corporacionaoe.app.models.entity.Producto;

@Service(value = "clienteService")
public class ClienteServiceImp implements IClienteService{
	
	@Autowired
	private IClienteDao clienteDao;
	
	@Autowired
	private IProductoDao productoDao;
	
	@Autowired
	private IFacturaDao facturaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		return (List<Cliente>) clienteDao.findAll();
	}

	@Override
	@Transactional
	public void save(Cliente cliente) {
		clienteDao.save(cliente);
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findOne(Long id) {
		return clienteDao.findById(id).orElse(null);
	}


	@Override
	@Transactional
	public Cliente fetchByIdWhitFacturas(Long id) {
		return clienteDao.fetchByIdWhitFacturas(id);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		clienteDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Cliente> findAll(Pageable pageable) {
		return clienteDao.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Producto> findByNombre(String term) {
		return productoDao.buscarPorNombre(term);
		//Hibernate 5.6.7 da problemas con esta consulta
//		return productoDao.findByNombreLikeIgnoreCase("%"+term+"%");
	}

	@Override
	@Transactional
	public void saveFactura(Factura factura) {
		facturaDao.save(factura);
	}

	@Override
	@Transactional(readOnly = true)
	public Producto findProductoById(Long id) {
		return productoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Factura findFacturaById(Long id) {
		return facturaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void deleteFactura(Long id) {
		facturaDao.deleteById(id);
	}

	@Override
	@Transactional
	public Factura fetchFacturaByIdWhitClienteWhitItemFacturaWhitProducto(Long id) {
		// TODO Auto-generated method stub
		return facturaDao.fetchByIdWhitClienteWhitItemFacturaWhitProducto(id);
	}

}
