package br.com.gda.business.cartSnapshot.info;

import java.util.List;

import br.com.gda.business.materialSnapshot.info.MatsnapInfo;
import br.com.gda.info.obsolete.InfoMerger_;

final class CartSnapMergerMatSnap extends InfoMerger_<CartSnapInfo, MatsnapInfo, CartSnapInfo> {
	public CartSnapInfo merge(MatsnapInfo sourceOne, CartSnapInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new CartSnapVisitorMatSnap());
	}
	
	
	
	public List<CartSnapInfo> merge(List<MatsnapInfo> sourceOnes, List<CartSnapInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new CartSnapVisitorMatSnap());
	}
}
