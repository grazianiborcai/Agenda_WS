package br.com.gda.business.cart.info;

import java.util.List;

import br.com.gda.business.feeStore.info.FeeStoreInfo;
import br.com.gda.info.InfoMerger_;

final class CartMergerFeeStore extends InfoMerger_<CartInfo, FeeStoreInfo, CartInfo> {
	public CartInfo merge(FeeStoreInfo sourceOne, CartInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new CartVisitorFeeStore());
	}
	
	
	
	public List<CartInfo> merge(List<FeeStoreInfo> sourceOnes, List<CartInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new CartVisitorFeeStore());
	}
}
