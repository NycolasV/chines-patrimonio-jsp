package br.info.pweb.chines.ws.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.info.pweb.chines.exceptions.MyEntityNotFoundException;
import br.info.pweb.chines.services.ItemPatrimonioService;

@RestController
@RequestMapping("/rest/item-patrimonios")
public class ItemPatrimonioRestController {

	@Autowired
	private ItemPatrimonioService itemPatrimonioService;
	
	@GetMapping
	public ResponseEntity<Object> listar() {
		try {
			return ResponseEntity.ok(itemPatrimonioService.listar());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> buscar(@PathVariable Long id) {		
		try {
			return ResponseEntity.ok(itemPatrimonioService.buscar(id));
		} catch (MyEntityNotFoundException e) {
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
}
