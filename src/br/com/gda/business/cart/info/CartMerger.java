package br.com.gda.business.cart.info;

import java.util.List;

import br.com.gda.business.cartItem.info.CartemInfo;
import br.com.gda.business.feeDefault.info.FeedefInfo;
import br.com.gda.business.masterData.info.CurrencyInfo;
import br.com.gda.info.InfoMerger;
import br.com.gda.security.username.info.UsernameInfo;

public final class CartMerger {	
	public static CartInfo mergeWithFeedef(FeedefInfo sourceOne, CartInfo sourceTwo) {
		InfoMerger<CartInfo, FeedefInfo> merger = new CartMergerFeedef();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CartInfo> mergeWithFeedef(List<FeedefInfo> sourceOnes, List<CartInfo> sourceTwos) {
		InfoMerger<CartInfo, FeedefInfo> merger = new CartMergerFeedef();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
	
	
	
	public static CartInfo mergeWithCurrency(CurrencyInfo sourceOne, CartInfo sourceTwo) {
		InfoMerger<CartInfo, CurrencyInfo> merger = new CartMergerCurrency();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CartInfo> mergeWithCurrency(List<CurrencyInfo> sourceOnes, List<CartInfo> sourceTwos) {
		InfoMerger<CartInfo, CurrencyInfo> merger = new CartMergerCurrency();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
	
	
	
	public static CartInfo mergeWithCartem(CartemInfo sourceOne, CartInfo sourceTwo) {
		InfoMerger<CartInfo, CartemInfo> merger = new CartMergerCartem();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CartInfo> mergeWithCartem(List<CartemInfo> sourceOnes, List<CartInfo> sourceTwos) {
		InfoMerger<CartInfo, CartemInfo> merger = new CartMergerCartem();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
	
	
	
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
