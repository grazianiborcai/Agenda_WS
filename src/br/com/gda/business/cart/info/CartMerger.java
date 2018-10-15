package br.com.gda.business.cart.info;

import java.util.List;

import br.com.gda.business.feeStore.info.FeeStoreInfo;
import br.com.gda.business.masterData.info.CartCategInfo;
import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.business.totalAmount.info.TotAmountInfo;
import br.com.gda.info.InfoWritterFactory;

public final class CartMerger extends InfoWritterFactory<CartInfo> {	
	
	public CartMerger() {
		super(new CartUniquifier());
	}
	
	
	
	static public CartInfo merge(MatInfo sourceOne, CartInfo sourceTwo) {
		return new CartMergerMat().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public CartInfo merge(StoreInfo sourceOne, CartInfo sourceTwo) {
		return new CartMergerStore().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public CartInfo merge(CartCategInfo sourceOne, CartInfo sourceTwo) {
		return new CartMergerCateg().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public CartInfo merge(WeekdayInfo sourceOne, CartInfo sourceTwo) {
		return new CartMergerWeekday().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public CartInfo merge(FeeStoreInfo sourceOne, CartInfo sourceTwo) {
		return new CartMergerFee().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public CartInfo merge(TotAmountInfo sourceOne, CartInfo sourceTwo) {
		return new CartMergerTotAmount().merge(sourceOne, sourceTwo);
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override protected List<CartInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {		
		if (sourceOnes.get(0) instanceof MatInfo 	&&
			sourceTwos.get(0) instanceof CartInfo		)
			return new CartMergerMat().merge((List<MatInfo>) sourceOnes, (List<CartInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof StoreInfo 	&&
			sourceTwos.get(0) instanceof CartInfo		)
			return new CartMergerStore().merge((List<StoreInfo>) sourceOnes, (List<CartInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof CartCategInfo 	&&
			sourceTwos.get(0) instanceof CartInfo		)
			return new CartMergerCateg().merge((List<CartCategInfo>) sourceOnes, (List<CartInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof WeekdayInfo 	&&
			sourceTwos.get(0) instanceof CartInfo		)
			return new CartMergerWeekday().merge((List<WeekdayInfo>) sourceOnes, (List<CartInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof FeeStoreInfo 	&&
			sourceTwos.get(0) instanceof CartInfo		)
			return new CartMergerFee().merge((List<FeeStoreInfo>) sourceOnes, (List<CartInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof TotAmountInfo 	&&
			sourceTwos.get(0) instanceof CartInfo		)
			return new CartMergerTotAmount().merge((List<TotAmountInfo>) sourceOnes, (List<CartInfo>) sourceTwos);
		
		
		return null;
	}
}
