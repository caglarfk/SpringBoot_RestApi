package com.example.demo.services;

import com.example.demo.exception.CityNotFoundException;
import com.example.demo.model.Cities;
import com.example.demo.repository.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CityServices {
private final CityRepository cityRepository;
    public List<Cities>getCity(String name){
if(name==null){
    return cityRepository.findAll();
}else {
    return cityRepository.findByName(name);
}


    }
    public Cities createCity(Cities newCity){

        return cityRepository.save(newCity);

    }
    public void  delById(String id){

         cityRepository.deleteById(id);

    }

    public Cities getCityById(String id) {
      return   cityRepository.findById(id)
                .orElseThrow(() -> new CityNotFoundException("City not found id"+id));

    }

    public void updateCity(String id, Cities newCty) {

      Cities  oldICty=cityRepository.findById(id).orElseThrow(() -> new RuntimeException("City not found"));
      oldICty.setName(newCty.getName());
      oldICty.setChild(newCty.getChild());
      cityRepository.save(oldICty);
    }
}
