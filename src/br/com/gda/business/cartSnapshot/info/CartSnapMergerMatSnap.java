package br.com.gda.business.cartSnapshot.info;

import java.util.List;

import br.com.gda.business.materialSnapshot.info.MatSnapInfo;
import br.com.gda.info.obsolete.InfoMerger_;

final class CartSnapMergerMatSnap extends InfoMerger_<CartSnapInfo, MatSnapInfo, CartSnapInfo> {
	public CartSnapInfo merge(MatSnapInfo sourceOne, CartSnapInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new CartSnapVisitorMatSnap());
	}
	
	
	
	public List<CartSnapInfo> merge(List<MatSnapInfo> sourceOnes, List<CartSnapInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new CartSnapVisitorMatSnap());
	}
}
