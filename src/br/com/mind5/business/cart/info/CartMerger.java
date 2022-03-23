package br.com.mind5.business.cart.info;

import java.util.List;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.feeOwner.info.FeewnerInfo;
import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.masterData.currency.info.CurrencyInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class CartMerger {	
	public static List<CartInfo> mergeWithOrder(List<CartInfo> baseInfos, List<OrderInfo> selectedInfos) {
		InfoMergerBuilder<CartInfo, OrderInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CartMergerVisiOrder());
		InfoMerger<CartInfo, OrderInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<CartInfo> mergeWithFeewner(List<CartInfo> baseInfos, List<FeewnerInfo> selectedInfos) {
		InfoMergerBuilder<CartInfo, FeewnerInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CartMergerVisiFeewner());
		InfoMerger<CartInfo, FeewnerInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<CartInfo> mergeWithCurrency(List<CartInfo> baseInfos, List<CurrencyInfo> selectedInfos) {
		InfoMergerBuilder<CartInfo, CurrencyInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CartMergerVisiCurrency());
		InfoMerger<CartInfo, CurrencyInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<CartInfo> mergeWithCartem(List<CartInfo> baseInfos, List<CartemInfo> selectedInfos) {
		InfoMergerBuilder<CartInfo, CartemInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CartMergerVisiCartem());
		InfoMerger<CartInfo, CartemInfo> merger = builder.build();		
	
		return merger.merge();
	}		
	
	
	
	public static List<CartInfo> mergeWithUsername(List<CartInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilder<CartInfo, UsernameInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CartMergerVisiUsername());
		InfoMerger<CartInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}		
	
	
	
	public static List<CartInfo> mergeToSelect(List<CartInfo> baseInfos, List<CartInfo> selectedInfos) {
		InfoMergerBuilder<CartInfo, CartInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CartMergerVisiToSelect());
		InfoMerger<CartInfo, CartInfo> merger = builder.build();		
	
		return merger.merge();
	}		
	
	
	
	public static List<CartInfo> mergeToUpdate(List<CartInfo> baseInfos, List<CartInfo> selectedInfos) {
		InfoMergerBuilder<CartInfo, CartInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CartMergerVisiToUpdate());
		InfoMerger<CartInfo, CartInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<CartInfo> mergeToEmptfy(List<CartInfo> baseInfos, List<CartInfo> selectedInfos) {
		InfoMergerBuilder<CartInfo, CartInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CartMergerVisiToEmptfy());
		InfoMerger<CartInfo, CartInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
