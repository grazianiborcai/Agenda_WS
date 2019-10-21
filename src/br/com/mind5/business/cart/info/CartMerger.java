package br.com.mind5.business.cart.info;

import java.util.List;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.feeOwner.info.FeewnerInfo;
import br.com.mind5.business.masterData.info.CurrencyInfo;
import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.security.username.info.UsernameInfo;

public final class CartMerger {	
	public static CartInfo mergeWithOrder(OrderInfo sourceOne, CartInfo sourceTwo) {
		InfoMerger<CartInfo, OrderInfo> merger = new CartMergerOrder();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CartInfo> mergeWithOrder(List<OrderInfo> sourceOnes, List<CartInfo> sourceTwos) {
		InfoMerger<CartInfo, OrderInfo> merger = new CartMergerOrder();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
	
	
	
	public static CartInfo mergeWithFeewner(FeewnerInfo sourceOne, CartInfo sourceTwo) {
		InfoMerger<CartInfo, FeewnerInfo> merger = new CartMergerFeewner();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CartInfo> mergeWithFeewner(List<FeewnerInfo> sourceOnes, List<CartInfo> sourceTwos) {
		InfoMerger<CartInfo, FeewnerInfo> merger = new CartMergerFeewner();		
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
