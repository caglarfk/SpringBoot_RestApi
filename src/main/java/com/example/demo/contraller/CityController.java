package com.example.demo.contraller;


import com.example.demo.exception.CityNotFoundException;
import com.example.demo.model.Cities;
import com.example.demo.services.CityServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/city")
@AllArgsConstructor
public class CityController {

private final CityServices cityServices;

    @GetMapping
public ResponseEntity<List<Cities>> getCitys(@RequestParam(required = false) String name){

return  new ResponseEntity<>(cityServices.getCity(name), HttpStatus.OK);

}

@GetMapping("/{id}")
    public ResponseEntity<Cities> getById(@PathVariable String id){

                return new ResponseEntity<>(cityServices.getCityById(id),HttpStatus.OK);
}


@PostMapping
    public  ResponseEntity<Cities>postCity(@RequestBody Cities newCity){

   return new ResponseEntity<Cities>(cityServices.createCity(newCity),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void>getCty(@PathVariable  String id,@RequestBody Cities newCty){
        cityServices.updateCity(id,newCty);

        return new ResponseEntity<>(HttpStatus.OK);

    }

@DeleteMapping("/{id}")
public  ResponseEntity<Void>delCty(@PathVariable String id){
                cityServices.delById(id);
       return new ResponseEntity<>(HttpStatus.OK);
}


private  Cities getCtyById(String id){
return  cityServices.getCityById(id);


}

@ExceptionHandler(CityNotFoundException.class)
    public ResponseEntity<String> handleCityNotFoundException(CityNotFoundException ex){
return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
}
    }
