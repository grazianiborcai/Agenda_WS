package br.com.gda.business.cartSnapshot.info;

import java.util.List;

import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.info.InfoMerger;

final class CartSnapMergerStore extends InfoMerger<CartSnapInfo, StoreInfo, CartSnapInfo> {
	public CartSnapInfo merge(StoreInfo sourceOne, CartSnapInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new CartSnapVisitorStore());
	}
	
	
	
	public List<CartSnapInfo> merge(List<StoreInfo> sourceOnes, List<CartSnapInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new CartSnapVisitorStore());
	}
}
