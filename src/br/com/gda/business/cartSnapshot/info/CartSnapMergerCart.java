package br.com.gda.business.cartSnapshot.info;

import java.util.List;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.info.InfoMerger;

final class CartSnapMergerCart extends InfoMerger<CartSnapInfo, CartInfo, CartSnapInfo> {
	public CartSnapInfo merge(CartInfo sourceOne, CartSnapInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new CartSnapVisitorCart());
	}
	
	
	
	public List<CartSnapInfo> merge(List<CartInfo> sourceOnes, List<CartSnapInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new CartSnapVisitorCart());
	}
}
