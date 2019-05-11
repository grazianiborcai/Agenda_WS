package br.com.gda.business.cartSnapshot.info;

import java.util.List;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.business.masterData.info.CartCategInfo;
import br.com.gda.business.masterData.info.CurrencyInfo;
import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.business.materialSnapshot.info.MatSnapInfo;
import br.com.gda.business.snapshot.info.SnapInfo;
import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.info.obsolete.InfoWritterFactory_;

public final class CartSnapMerger extends InfoWritterFactory_<CartSnapInfo> {	
	
	public CartSnapMerger() {
		super(new CartSnapUniquifier());
	}
	
	
	
	static public CartSnapInfo merge(MatSnapInfo sourceOne, CartSnapInfo sourceTwo) {
		return new CartSnapMergerMatSnap().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public CartSnapInfo merge(StoreInfo sourceOne, CartSnapInfo sourceTwo) {
		return new CartSnapMergerStore().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public CartSnapInfo merge(WeekdayInfo sourceOne, CartSnapInfo sourceTwo) {
		return new CartSnapMergerWeekday().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public CartSnapInfo merge(CartInfo sourceOne, CartSnapInfo sourceTwo) {
		return new CartSnapMergerCart().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public CartSnapInfo merge(SnapInfo sourceOne, CartSnapInfo sourceTwo) {
		return new CartSnapMergerSnap().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public CartSnapInfo merge(CartCategInfo sourceOne, CartSnapInfo sourceTwo) {
		return new CartSnapMergerCartCateg().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public CartSnapInfo merge(CurrencyInfo sourceOne, CartSnapInfo sourceTwo) {
		return new CartSnapMergerCurrency().merge(sourceOne, sourceTwo);
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override protected List<CartSnapInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {		
		if (sourceOnes.get(0) instanceof MatSnapInfo 			&&
			sourceTwos.get(0) instanceof CartSnapInfo		)
			return new CartSnapMergerMatSnap().merge((List<MatSnapInfo>) sourceOnes, (List<CartSnapInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof StoreInfo 				&&
			sourceTwos.get(0) instanceof CartSnapInfo		)
			return new CartSnapMergerStore().merge((List<StoreInfo>) sourceOnes, (List<CartSnapInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof WeekdayInfo 			&&
			sourceTwos.get(0) instanceof CartSnapInfo		)
			return new CartSnapMergerWeekday().merge((List<WeekdayInfo>) sourceOnes, (List<CartSnapInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof CartInfo 				&&
			sourceTwos.get(0) instanceof CartSnapInfo		)
			return new CartSnapMergerCart().merge((List<CartInfo>) sourceOnes, (List<CartSnapInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof SnapInfo 				&&
			sourceTwos.get(0) instanceof CartSnapInfo		)
			return new CartSnapMergerSnap().merge((List<SnapInfo>) sourceOnes, (List<CartSnapInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof CartCategInfo 			&&
			sourceTwos.get(0) instanceof CartSnapInfo		)
			return new CartSnapMergerCartCateg().merge((List<CartCategInfo>) sourceOnes, (List<CartSnapInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof CurrencyInfo 			&&
			sourceTwos.get(0) instanceof CartSnapInfo		)
			return new CartSnapMergerCurrency().merge((List<CurrencyInfo>) sourceOnes, (List<CartSnapInfo>) sourceTwos);
		
		
		return null;
	}
}
