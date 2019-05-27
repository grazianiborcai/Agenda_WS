package br.com.gda.business.cartItem.info;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.info.InfoCopierOneToManyTemplate;

final class CartemCopyCart extends InfoCopierOneToManyTemplate<CartemInfo, CartInfo>{
	
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
			logException(e);
			throw new IllegalStateException(e); 
		}
	}	
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
