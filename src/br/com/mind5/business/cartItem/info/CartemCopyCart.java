package br.com.mind5.business.cartItem.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.cart.info.CartInfo;
import br.com.mind5.info.InfoCopierOneToManyTemplate;

final class CartemCopyCart extends InfoCopierOneToManyTemplate<CartemInfo, CartInfo> {
	
	public CartemCopyCart() {
		super();
	}
	
	
	
	@Override protected List<CartemInfo> makeCopyHook(CartInfo source) {	
		List<CartemInfo> results = new ArrayList<>();
		
		for (CartemInfo eachCartem : source.cartems) {
			results.add(makeClone(eachCartem));
		}
		
		return results;
	}
	
	
	
	private CartemInfo makeClone(CartemInfo recordInfo) {
		try {
			return (CartemInfo) recordInfo.clone();
			
		} catch (Exception e) {
			super.logException(e);
			throw new IllegalStateException(e); 
		}
	}	
}
