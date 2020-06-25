package com.mmn.payment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mmn.payment.model.entity.Product;
import com.mmn.payment.model.entity.Subscription;
import com.mmn.payment.model.type.ProductCategoryType;
import com.mmn.payment.repository.ProductRepository;
import com.mmn.payment.repository.SubscriptionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

	private final ProductRepository productRepository;
	private final SubscriptionRepository subscriptionRepository;

	public List<Product> listAvaiableSystemProducts(String subscriptonId) {
		return this.productRepository.findByCategoryIn(
				listarCategoriasSistema(subscriptonId)
				);
	}

	private List<ProductCategoryType> listarCategoriasSistema(String subscriptonId) {
		return this.listarCategorias(
				subscriptonId, 
				ProductCategoryType.MARKETPLACE,
				ProductCategoryType.UNLIMITED_PASSPORTS_TO_SEND,
				ProductCategoryType.IDECIDE_INTERACTIVE_SALES_SYSTEM,
				ProductCategoryType.PERCENT_OF_REFERRAL_DIRECT_INVITATION,
				ProductCategoryType.LEVEL_OF_REFERRAL_DIRECT_INVITATION,
				ProductCategoryType.TRAVINED_ONLINE_BACK_OFFICE_MLM_MANAGEMENT,
				ProductCategoryType.PERCENT_PASSPORTS_BONUSES
				);
	}

	public List<Product> listAvaiableMyTrip(String subscriptonId) {
		return this.productRepository.findByCategoryIn(
				listarCategoriasMyTrip(subscriptonId)
				);
	}

	private List<ProductCategoryType> listarCategoriasMyTrip(String subscriptonId) {
		return this.listarCategorias(
				subscriptonId, 
				ProductCategoryType.CRUISES,
				ProductCategoryType.FLIGHTS,
				ProductCategoryType.HOMES,
				ProductCategoryType.HOTELS,
				ProductCategoryType.WEEKS,
				ProductCategoryType.RENTAL_CARS
				);
	}
	
	private List<ProductCategoryType> listarCategorias(String subscriptonId, ProductCategoryType... productCategoryType) {
		List<ProductCategoryType> result = new ArrayList<ProductCategoryType>();
		Subscription subscription = this.subscriptionRepository.findById(subscriptonId).get();
		for (int i = 0; i < productCategoryType.length; i++) {
			ProductCategoryType catetory = subscription.getProduct().contains(productCategoryType[i]);
			if (catetory != null) {
				result.add(catetory);
			}
		}		
		return result;
	}
	
	
}
