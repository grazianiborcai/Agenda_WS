package br.com.gda.business.cart.info;

import java.util.List;

import br.com.gda.business.feeStore.info.FeetoreInfo;
import br.com.gda.info.obsolete.InfoMerger_;

final class CartMergerFeeStore extends InfoMerger_<CartInfo, FeetoreInfo, CartInfo> {
	public CartInfo merge(FeetoreInfo sourceOne, CartInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new CartVisitorFeeStore());
	}
	
	
	
	public List<CartInfo> merge(List<FeetoreInfo> sourceOnes, List<CartInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new CartVisitorFeeStore());
	}
}
