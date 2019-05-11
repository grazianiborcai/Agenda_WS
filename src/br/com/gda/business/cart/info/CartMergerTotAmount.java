package br.com.gda.business.cart.info;

import java.util.List;

import br.com.gda.business.totalAmount.info.TotAmountInfo;
import br.com.gda.info.obsolete.InfoMerger_;

final class CartMergerTotAmount extends InfoMerger_<CartInfo, TotAmountInfo, CartInfo> {
	public CartInfo merge(TotAmountInfo sourceOne, CartInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new CartVisitorTotAmount());
	}
	
	
	
	public List<CartInfo> merge(List<TotAmountInfo> sourceOnes, List<CartInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new CartVisitorTotAmount());
	}
}
