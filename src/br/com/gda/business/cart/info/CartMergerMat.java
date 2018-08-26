package br.com.gda.business.cart.info;

import java.util.List;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.info.InfoWriter;

final class CartMergerMat extends InfoWriter<CartInfo, MatInfo, CartInfo> {
	public CartInfo merge(MatInfo sourceOne, CartInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new CartVisitorMat());
	}
	
	
	
	public List<CartInfo> merge(List<MatInfo> sourceOnes, List<CartInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new CartVisitorMat());
	}
}
