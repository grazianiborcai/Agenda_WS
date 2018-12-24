package br.com.gda.business.cart.info;

import java.util.List;

import br.com.gda.business.masterData.info.CartCategInfo;
import br.com.gda.info.InfoMerger;

final class CartMergerCartCateg extends InfoMerger<CartInfo, CartCategInfo, CartInfo> {
	public CartInfo merge(CartCategInfo sourceOne, CartInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new CartVisitorCartCateg());
	}
	
	
	
	public List<CartInfo> merge(List<CartCategInfo> sourceOnes, List<CartInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new CartVisitorCartCateg());
	}
}
