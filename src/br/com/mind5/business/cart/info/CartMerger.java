package br.com.mind5.business.cart.info;

import java.util.List;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.feeOwner.info.FeewnerInfo;
import br.com.mind5.business.masterData.info.CurrencyInfo;
import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.info.obsolete.InfoMerger_;
import br.com.mind5.security.username.info.UsernameInfo;

public final class CartMerger {	
	public static CartInfo mergeWithOrder(OrderInfo selectedInfo, CartInfo baseInfo) {
		InfoMerger_<CartInfo, OrderInfo> merger = new CartMergerOrder();		
		return merger.merge(selectedInfo, baseInfo);
	}
	
	
	
	public static List<CartInfo> mergeWithOrder(List<OrderInfo> selectedInfos, List<CartInfo> baseInfos) {
		InfoMerger_<CartInfo, OrderInfo> merger = new CartMergerOrder();		
		return merger.merge(selectedInfos, baseInfos);
	}	
	
	
	
	public static CartInfo mergeWithFeewner(FeewnerInfo selectedInfo, CartInfo baseInfo) {
		InfoMerger_<CartInfo, FeewnerInfo> merger = new CartMergerFeewner();		
		return merger.merge(selectedInfo, baseInfo);
	}
	
	
	
	public static List<CartInfo> mergeWithFeewner(List<FeewnerInfo> selectedInfos, List<CartInfo> baseInfos) {
		InfoMerger_<CartInfo, FeewnerInfo> merger = new CartMergerFeewner();		
		return merger.merge(selectedInfos, baseInfos);
	}	
	
	
	
	public static CartInfo mergeWithCurrency(CurrencyInfo selectedInfo, CartInfo baseInfo) {
		InfoMerger_<CartInfo, CurrencyInfo> merger = new CartMergerCurrency();		
		return merger.merge(selectedInfo, baseInfo);
	}
	
	
	
	public static List<CartInfo> mergeWithCurrency(List<CurrencyInfo> selectedInfos, List<CartInfo> baseInfos) {
		InfoMerger_<CartInfo, CurrencyInfo> merger = new CartMergerCurrency();		
		return merger.merge(selectedInfos, baseInfos);
	}		
	
	
	
	public static CartInfo mergeWithCartem(CartemInfo selectedInfo, CartInfo baseInfo) {
		InfoMerger_<CartInfo, CartemInfo> merger = new CartMergerCartem();		
		return merger.merge(selectedInfo, baseInfo);
	}
	
	
	
	public static List<CartInfo> mergeWithCartem(List<CartemInfo> selectedInfos, List<CartInfo> baseInfos) {
		InfoMerger_<CartInfo, CartemInfo> merger = new CartMergerCartem();		
		return merger.merge(selectedInfos, baseInfos);
	}		
	
	
	
	public static CartInfo mergeWithUsername(UsernameInfo selectedInfo, CartInfo baseInfo) {
		InfoMerger_<CartInfo, UsernameInfo> merger = new CartMergerUsername();		
		return merger.merge(selectedInfo, baseInfo);
	}
	
	
	
	public static List<CartInfo> mergeWithUsername(List<UsernameInfo> selectedInfos, List<CartInfo> baseInfos) {
		InfoMerger_<CartInfo, UsernameInfo> merger = new CartMergerUsername();		
		return merger.merge(selectedInfos, baseInfos);
	}		
	
	
	
	public static CartInfo mergeToSelect(CartInfo selectedInfo, CartInfo baseInfo) {
		InfoMerger_<CartInfo, CartInfo> merger = new CartMergerToSelect();		
		return merger.merge(selectedInfo, baseInfo);
	}
	
	
	
	public static List<CartInfo> mergeToSelect(List<CartInfo> selectedInfos, List<CartInfo> baseInfos) {
		InfoMerger_<CartInfo, CartInfo> merger = new CartMergerToSelect();		
		return merger.merge(selectedInfos, baseInfos);
	}		
	
	
	
	public static CartInfo mergeToUpdate(CartInfo selectedInfo, CartInfo baseInfo) {
		InfoMerger_<CartInfo, CartInfo> merger = new CartMergerToUpdate();		
		return merger.merge(selectedInfo, baseInfo);
	}
	
	
	
	public static List<CartInfo> mergeToUpdate(List<CartInfo> selectedInfos, List<CartInfo> baseInfos) {
		InfoMerger_<CartInfo, CartInfo> merger = new CartMergerToUpdate();		
		return merger.merge(selectedInfos, baseInfos);
	}	
}
