package br.com.gda.business.cart.info;

import java.util.List;

import br.com.gda.business.feeDefault.info.FeeDefaultInfo;
import br.com.gda.business.feeStore.info.FeeStoreInfo;
import br.com.gda.business.masterData.info.CartCategInfo;
import br.com.gda.business.masterData.info.CurrencyInfo;
import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.business.totalAmount.info.TotAmountInfo;
import br.com.gda.business.user.info.UserInfo;
import br.com.gda.info.InfoWritterFactory_;

public final class CartMerger extends InfoWritterFactory_<CartInfo> {	
	
	public CartMerger() {
		super(new CartUniquifier());
	}
	
	
	
	static public CartInfo merge(MatInfo sourceOne, CartInfo sourceTwo) {
		return new CartMergerMat().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public CartInfo merge(StoreInfo sourceOne, CartInfo sourceTwo) {
		return new CartMergerStore().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public CartInfo merge(WeekdayInfo sourceOne, CartInfo sourceTwo) {
		return new CartMergerWeekday().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public CartInfo merge(FeeStoreInfo sourceOne, CartInfo sourceTwo) {
		return new CartMergerFeeStore().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public CartInfo merge(FeeDefaultInfo sourceOne, CartInfo sourceTwo) {
		return new CartMergerFeeDefault().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public CartInfo merge(TotAmountInfo sourceOne, CartInfo sourceTwo) {
		return new CartMergerTotAmount().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public CartInfo merge(UserInfo sourceOne, CartInfo sourceTwo) {
		return new CartMergerUser().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public CartInfo merge(CartCategInfo sourceOne, CartInfo sourceTwo) {
		return new CartMergerCartCateg().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public CartInfo merge(CurrencyInfo sourceOne, CartInfo sourceTwo) {
		return new CartMergerCurrency().merge(sourceOne, sourceTwo);
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override protected List<CartInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {		
		if (sourceOnes.get(0) instanceof MatInfo 			&&
			sourceTwos.get(0) instanceof CartInfo		)
			return new CartMergerMat().merge((List<MatInfo>) sourceOnes, (List<CartInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof StoreInfo 			&&
			sourceTwos.get(0) instanceof CartInfo		)
			return new CartMergerStore().merge((List<StoreInfo>) sourceOnes, (List<CartInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof WeekdayInfo 		&&
			sourceTwos.get(0) instanceof CartInfo		)
			return new CartMergerWeekday().merge((List<WeekdayInfo>) sourceOnes, (List<CartInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof FeeStoreInfo 		&&
			sourceTwos.get(0) instanceof CartInfo		)
			return new CartMergerFeeStore().merge((List<FeeStoreInfo>) sourceOnes, (List<CartInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof FeeDefaultInfo 	&&
			sourceTwos.get(0) instanceof CartInfo		)
			return new CartMergerFeeDefault().merge((List<FeeDefaultInfo>) sourceOnes, (List<CartInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof TotAmountInfo 		&&
			sourceTwos.get(0) instanceof CartInfo		)
			return new CartMergerTotAmount().merge((List<TotAmountInfo>) sourceOnes, (List<CartInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof UserInfo 			&&
			sourceTwos.get(0) instanceof CartInfo		)
			return new CartMergerUser().merge((List<UserInfo>) sourceOnes, (List<CartInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof CartCategInfo 		&&
			sourceTwos.get(0) instanceof CartInfo		)
			return new CartMergerCartCateg().merge((List<CartCategInfo>) sourceOnes, (List<CartInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof CurrencyInfo 		&&
			sourceTwos.get(0) instanceof CartInfo		)
			return new CartMergerCurrency().merge((List<CurrencyInfo>) sourceOnes, (List<CartInfo>) sourceTwos);
		
		
		return null;
	}
}
