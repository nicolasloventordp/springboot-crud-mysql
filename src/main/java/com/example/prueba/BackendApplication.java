package com.example.prueba;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.prueba.model.Producto;
import com.example.prueba.service.ProductoService;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	public CommandLineRunner cargarProductos(ProductoService service) {
		return args -> {
			if(service.listarTodos().isEmpty()) {
				service.guardar(new Producto("Yerba"));
				service.guardar(new Producto("Pepsi"));
				System.out.println(service.listarTodos());
			}
			
		};
	}

}
