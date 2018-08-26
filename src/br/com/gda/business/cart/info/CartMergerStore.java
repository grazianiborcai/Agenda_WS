package br.com.gda.business.cart.info;

import java.util.List;

import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.info.InfoWriter;

final class CartMergerStore extends InfoWriter<CartInfo, StoreInfo, CartInfo> {
	public CartInfo merge(StoreInfo sourceOne, CartInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new CartVisitorStore());
	}
	
	
	
	public List<CartInfo> merge(List<StoreInfo> sourceOnes, List<CartInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new CartVisitorStore());
	}
}
