package com.meters.metersapi.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meters.metersapi.models.Medidores;
import com.meters.metersapi.repository.MetersRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping
@Api(value="API Rest Medidores")
@CrossOrigin(origins="*")
public class MedidoresResource {

	@Autowired
	MetersRepository metersRepository;
	
	@GetMapping("/portfolio")
	@ApiOperation(value="Retorna uma lista de todos os modelos de medidores")
	public List<Medidores> listMeters(){
		return metersRepository.findAll();
	}
	
	@GetMapping("/portfolio/{id}")
	@ApiOperation(value="Retorna um medidor especifico de acordo com o ID")
	public Optional<Medidores> findById(@PathVariable(value="id") Integer id) {
		return metersRepository.findById(id);
	}
	
	@PostMapping("/portfolio")
	@ApiOperation(value="Salva um novo medidor na tabela")
	public Medidores salvaMedidor(@RequestBody Medidores medidores) {
		return metersRepository.save(medidores);
	}
	
	@DeleteMapping("/portfolio")
	@ApiOperation(value="Deleta um medidor")
	public void deletaMedidor(@RequestBody Medidores medidores) {
		metersRepository.delete(medidores);
	}
	
	@PutMapping("/portfolio")
	@ApiOperation(value="Atualiza um medidor")
	public Medidores atualizarMedidor(@RequestBody Medidores medidores) {
		return metersRepository.save(medidores);
	}
	
	
	
	
	
}
