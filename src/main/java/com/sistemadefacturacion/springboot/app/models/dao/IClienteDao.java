package com.sistemadefacturacion.springboot.app.models.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.sistemadefacturacion.springboot.app.models.entity.Cliente;

public interface IClienteDao extends PagingAndSortingRepository<Cliente, Long>{

}
