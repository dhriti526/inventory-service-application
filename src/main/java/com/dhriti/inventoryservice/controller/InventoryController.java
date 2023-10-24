package com.dhriti.inventoryservice.controller;

import com.dhriti.inventoryservice.DTO.InventoryResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dhriti.inventoryservice.service.InventoryService;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
@Slf4j
public class InventoryController {
	
	@Autowired
	private InventoryService inventoryService;
	
	@GetMapping("/{sku-code}")
	public List<InventoryResponse> isInStock(@PathVariable("sku-code") String skuCode)	{
		log.info("Received inventory check request for skuCode: {}", skuCode);
		return inventoryService.isInStock(skuCode);
		
	}

}
