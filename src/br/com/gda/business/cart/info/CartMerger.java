package br.com.gda.business.cart.info;

import java.util.List;

import br.com.gda.info.InfoMerger;
import br.com.gda.security.username.info.UsernameInfo;

public final class CartMerger {	
	public static CartInfo mergeWithUsername(UsernameInfo sourceOne, CartInfo sourceTwo) {
		InfoMerger<CartInfo, UsernameInfo> merger = new CartMergerUsername();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CartInfo> mergeWithUsername(List<UsernameInfo> sourceOnes, List<CartInfo> sourceTwos) {
		InfoMerger<CartInfo, UsernameInfo> merger = new CartMergerUsername();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
	
	
	
	public static CartInfo mergeToSelect(CartInfo sourceOne, CartInfo sourceTwo) {
		InfoMerger<CartInfo, CartInfo> merger = new CartMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CartInfo> mergeToSelect(List<CartInfo> sourceOnes, List<CartInfo> sourceTwos) {
		InfoMerger<CartInfo, CartInfo> merger = new CartMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
}
