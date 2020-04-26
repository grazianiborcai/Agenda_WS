package br.com.mind5.business.cart.info;

import java.util.List;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.feeOwner.info.FeewnerInfo;
import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.masterData.currency.info.CurrencyInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class CartMerger {	
	public static List<CartInfo> mergeWithOrder(List<CartInfo> baseInfos, List<OrderInfo> selectedInfos) {
		InfoMergerBuilderV3<CartInfo, OrderInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CartVisiMergeOrder());
		InfoMergerV3<CartInfo, OrderInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<CartInfo> mergeWithFeewner(List<CartInfo> baseInfos, List<FeewnerInfo> selectedInfos) {
		InfoMergerBuilderV3<CartInfo, FeewnerInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CartVisiMergeFeewner());
		InfoMergerV3<CartInfo, FeewnerInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<CartInfo> mergeWithCurrency(List<CartInfo> baseInfos, List<CurrencyInfo> selectedInfos) {
		InfoMergerBuilderV3<CartInfo, CurrencyInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CartVisiMergeCurrency());
		InfoMergerV3<CartInfo, CurrencyInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<CartInfo> mergeWithCartem(List<CartInfo> baseInfos, List<CartemInfo> selectedInfos) {
		InfoMergerBuilderV3<CartInfo, CartemInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CartVisiMergeCartem());
		InfoMergerV3<CartInfo, CartemInfo> merger = builder.build();		
	
		return merger.merge();
	}		
	
	
	
	public static List<CartInfo> mergeWithUsername(List<CartInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilderV3<CartInfo, UsernameInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CartVisiMergeUsername());
		InfoMergerV3<CartInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}		
	
	
	
	public static List<CartInfo> mergeToSelect(List<CartInfo> baseInfos, List<CartInfo> selectedInfos) {
		InfoMergerBuilderV3<CartInfo, CartInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CartVisiMergeToSelect());
		InfoMergerV3<CartInfo, CartInfo> merger = builder.build();		
	
		return merger.merge();
	}		
	
	
	
	public static List<CartInfo> mergeToUpdate(List<CartInfo> baseInfos, List<CartInfo> selectedInfos) {
		InfoMergerBuilderV3<CartInfo, CartInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CartVisiMergeToUpdate());
		InfoMergerV3<CartInfo, CartInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
