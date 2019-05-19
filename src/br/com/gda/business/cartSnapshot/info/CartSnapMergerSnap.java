package br.com.gda.business.cartSnapshot.info;

import java.util.List;

import br.com.gda.business.snapshot_.info.SnapInfo;
import br.com.gda.info.obsolete.InfoMerger_;

final class CartSnapMergerSnap extends InfoMerger_<CartSnapInfo, SnapInfo, CartSnapInfo> {
	public CartSnapInfo merge(SnapInfo sourceOne, CartSnapInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new CartSnapVisitorSnap());
	}
	
	
	
	public List<CartSnapInfo> merge(List<SnapInfo> sourceOnes, List<CartSnapInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new CartSnapVisitorSnap());
	}
}
