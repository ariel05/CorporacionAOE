package com.corporacionaoe.app.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.corporacionaoe.app.models.entity.Producto;

public interface IProductoDao extends CrudRepository<Producto, Long>{
	
	@Query("select p from Producto p where p.nombre like %?1%")
	public List<Producto> buscarPorNombre(String term);
	
	List<Producto> findByNombreLikeIgnoreCase(String term);
}
