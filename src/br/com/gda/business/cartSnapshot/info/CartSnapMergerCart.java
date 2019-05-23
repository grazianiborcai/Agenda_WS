package br.com.gda.business.cartSnapshot.info;

import java.util.List;

import br.com.gda.business.cartItem.info.CartemInfo;
import br.com.gda.info.obsolete.InfoMerger_;

final class CartSnapMergerCart extends InfoMerger_<CartSnapInfo, CartemInfo, CartSnapInfo> {
	public CartSnapInfo merge(CartemInfo sourceOne, CartSnapInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new CartSnapVisitorCart());
	}
	
	
	
	public List<CartSnapInfo> merge(List<CartemInfo> sourceOnes, List<CartSnapInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new CartSnapVisitorCart());
	}
}
