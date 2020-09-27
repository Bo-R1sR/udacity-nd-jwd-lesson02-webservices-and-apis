package com.udacity.pricing.PriceMicroservice.repository;


import com.udacity.pricing.PriceMicroservice.entity.Price;
import org.springframework.data.repository.CrudRepository;

public interface PriceRepository extends CrudRepository<Price, Long> {
}
