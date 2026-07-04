package com.techlab.ecommerce;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.techlab.ecommerce.model.Categoria;
import com.techlab.ecommerce.model.Producto;
import com.techlab.ecommerce.service.CategoriaService;
import com.techlab.ecommerce.service.ProductoService;


@SpringBootApplication
public class EcommerceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcommerceApplication.class, args);
    }
   
	// Carga datos iniciales SOLO si la base está vacía.
    // Así evitamos duplicar los productos en cada reinicio.
   @Bean
    CommandLineRunner cargarDatos(CategoriaService categoriaService,
                                  ProductoService productoService) {
        return args -> {
            if (categoriaService.listarTodas().isEmpty()) {

                // 1. Registro e inicialización de las categorías principales
                Categoria frutaSeca = categoriaService.guardar(
                    new Categoria(null, "Fruta Seca", "Fruta seca y deshidratada")
                );
                Categoria varios = categoriaService.guardar(
                    new Categoria(null, "Varios", "Productos Varios")
                );
                    
                // 2. Carga automatizada de productos cruzados por categoría

                // --- CATEGORÍA: FRUTA SECA ---
                productoService.guardar(new Producto(
                    null, 
                    "Nueces Peladas", 
                    19800.0, 30, 
                    "https://i.postimg.cc/gJ28pLDN/photo-1605525483148-8fb743b620da-q-80-w-1374-auto-format-fit-crop-ixlib-rb-4-1.jpg", 
                    frutaSeca
                ));

                productoService.guardar(new Producto(
                    null, 
                    "Almendras", 
                    11680.0, 45, 
                    "https://i.postimg.cc/CMNMD6wB/premium-photo-1675237625910-e5d354c03987-q-80-w-1374-auto-format-fit-crop-ixlib-rb-4-1.jpg", 
                    frutaSeca
                ));

                productoService.guardar(new Producto(
                    null, 
                    "Pasas rubias", 
                    7172.0, 20, 
                    "https://i.postimg.cc/bwqQg5t7/photo-1642102903918-b97c37955bbf-q-80-w-1374-auto-format-fit-crop-ixlib-rb-4-1.jpg", 
                    frutaSeca
                ));

                productoService.guardar(new Producto(
                    null, 
                    "Pasas negras", 
                    6270.0, 25, 
                    "https://i.postimg.cc/rppjqpqy/31.jpg", 
                    frutaSeca
                ));

                productoService.guardar(new Producto(
                    null, 
                    "Ciruelas sin carozo", 
                    14000.0, 40, 
                    "https://i.postimg.cc/JnzzT932/9.jpg", 
                    frutaSeca
                ));

                productoService.guardar(new Producto(
                    null, 
                    "Castañas de Caju", 
                    8230.0, 15, 
                    "https://i.postimg.cc/xC89GLnr/5.jpg", 
                    frutaSeca
                ));

                productoService.guardar(new Producto(
                    null, 
                    "Datiles", 
                    24300.0, 35, 
                    "https://i.postimg.cc/jC0Kr9NK/datilrojo.jpg", 
                    frutaSeca
                ));

                productoService.guardar(new Producto(
                    null, 
                    "Pistachos Con Cascara", 
                    10057.0, 10, 
                    "https://i.postimg.cc/CLknfpcG/32.jpg", 
                    frutaSeca
                ));

                productoService.guardar(new Producto(
                    null, 
                    "Almendras Con Chocolate", 
                    21100.0, 15, 
                    "https://i.postimg.cc/ncvQgtbd/144.jpg", 
                    frutaSeca
                ));

                productoService.guardar(new Producto(
                    null, 
                    "Mani Con Cáscara", 
                    2066.0, 80, 
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSBf_IidEk-iz-dJQ9ZqwdMnG_Pc6cfXBKtBLSRp_rY5_ZvwGVlEJWrkftoFL5b5sRJkiKw3tnBZQ5Nc8ZZE4MxSI_FT7RvvJY0d8Tqum6SJg&s=10", 
                    frutaSeca
                ));
                
                // --- CATEGORÍA: VARIOS ---
                productoService.guardar(new Producto(
                    null, 
                    "Granola Premium", 
                    11200.0, 
                    50, 
                    "https://i.postimg.cc/HLZrCYLg/128.jpg", 
                    varios
                ));

                productoService.guardar(new Producto(
                    null, 
                    "Aceite De Coco", 
                    21000.0, 20, 
                    "https://i.postimg.cc/Z5JnBBBm/CHIA-GRAAL-NEUTRO-360-1.jpg", 
                    varios
                ));

                productoService.guardar(new Producto(
                    null, 
                    "Miel Organica Liquida", 
                    7100.0, 15, 
                    "https://i.postimg.cc/9fq6c1mQ/227.jpg", 
                    varios
                ));

                productoService.guardar(new Producto(
                    null, 
                    "Crema De Mani", 
                    3400.0, 60, 
                    "https://i.postimg.cc/cHSb0SkF/sola-TA-1.jpg", 
                    varios
                ));

                productoService.guardar(new Producto(
                    null, 
                    "Cereal Mix Light", 
                    14340.0, 40, 
                    "https://i.postimg.cc/9fGLxkXZ/117.jpg", 
                    varios
                ));

                productoService.guardar(new Producto(
                    null, 
                    "Aceite De Coco Virgen", 
                    16100.0, 12, 
                    "https://i.postimg.cc/pdtZnBQT/CHIA-GRAAL-VIRGEN-360.jpg", 
                    varios
                ));

                productoService.guardar(new Producto(
                    null, 
                    "Hummus De Garbanzo", 
                    6700.0, 25, 
                    "https://i.postimg.cc/RV6QsYXh/hummus-de-garbanzo-Pampa.jpg", 
                    varios
                ));
            }
        };
    }
}