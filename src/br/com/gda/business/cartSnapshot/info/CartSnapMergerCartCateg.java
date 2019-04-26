package br.com.gda.business.cartSnapshot.info;

import java.util.List;

import br.com.gda.business.masterData.info.CartCategInfo;
import br.com.gda.info.InfoMerger_;

final class CartSnapMergerCartCateg extends InfoMerger_<CartSnapInfo, CartCategInfo, CartSnapInfo> {
	public CartSnapInfo merge(CartCategInfo sourceOne, CartSnapInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new CartSnapVisitorCartCateg());
	}
	
	
	
	public List<CartSnapInfo> merge(List<CartCategInfo> sourceOnes, List<CartSnapInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new CartSnapVisitorCartCateg());
	}
}
