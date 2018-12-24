package br.com.gda.business.cartSnapshot.info;

import java.util.List;

import br.com.gda.business.snapshot.info.SnapInfo;
import br.com.gda.info.InfoMerger;

final class CartSnapMergerSnap extends InfoMerger<CartSnapInfo, SnapInfo, CartSnapInfo> {
	public CartSnapInfo merge(SnapInfo sourceOne, CartSnapInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new CartSnapVisitorSnap());
	}
	
	
	
	public List<CartSnapInfo> merge(List<SnapInfo> sourceOnes, List<CartSnapInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new CartSnapVisitorSnap());
	}
}
