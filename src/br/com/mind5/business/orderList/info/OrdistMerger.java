package br.com.mind5.business.orderList.info;

import java.util.List;

import br.com.mind5.business.orderSearch.info.OrdarchInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.masterData.currency.info.CurrencyInfo;
import br.com.mind5.masterData.orderStatus.info.OrderatusInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class OrdistMerger {	
	public static List<OrdistInfo> mergeWithUsername(List<OrdistInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilderV3<OrdistInfo, UsernameInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdistVisiMergeUsername());
		InfoMergerV3<OrdistInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OrdistInfo> mergeWithOrdarch(List<OrdistInfo> baseInfos, List<OrdarchInfo> selectedInfos) {
		InfoMergerBuilderV3<OrdistInfo, OrdarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdistVisiMergeOrdarch());
		InfoMergerV3<OrdistInfo, OrdarchInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OrdistInfo> mergeWithCurrency(List<OrdistInfo> baseInfos, List<CurrencyInfo> selectedInfos) {
		InfoMergerBuilderV3<OrdistInfo, CurrencyInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdistVisiMergeCurrency());
		InfoMergerV3<OrdistInfo, CurrencyInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OrdistInfo> mergeWithOrderatus(List<OrdistInfo> baseInfos, List<OrderatusInfo> selectedInfos) {
		InfoMergerBuilderV3<OrdistInfo, OrderatusInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdistVisiMergeOrderatus());
		InfoMergerV3<OrdistInfo, OrderatusInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OrdistInfo> mergeToSelect(List<OrdistInfo> baseInfos, List<OrdistInfo> selectedInfos) {
		InfoMergerBuilderV3<OrdistInfo, OrdistInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdistVisiMergeToSelect());
		InfoMergerV3<OrdistInfo, OrdistInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
