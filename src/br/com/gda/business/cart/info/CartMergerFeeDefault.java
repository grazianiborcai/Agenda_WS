package br.com.gda.business.cart.info;

import java.util.List;

import br.com.gda.business.feeDefault.info.FeeDefaultInfo;
import br.com.gda.info.InfoMerger_;

final class CartMergerFeeDefault extends InfoMerger_<CartInfo, FeeDefaultInfo, CartInfo> {
	public CartInfo merge(FeeDefaultInfo sourceOne, CartInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new CartVisitorFeeDefault());
	}
	
	
	
	public List<CartInfo> merge(List<FeeDefaultInfo> sourceOnes, List<CartInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new CartVisitorFeeDefault());
	}
}
