package br.com.mind5.business.orderList.info;

import java.util.List;

import br.com.mind5.business.orderItemCounter.info.OrdereouInfo;
import br.com.mind5.business.orderSearch.info.OrdarchInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.masterData.currency.info.CurrencyInfo;
import br.com.mind5.masterData.orderStatus.info.OrderatusInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class OrdistMerger {	
	public static List<OrdistInfo> mergeWithOrdereou(List<OrdistInfo> baseInfos, List<OrdereouInfo> selectedInfos) {
		InfoMergerBuilder<OrdistInfo, OrdereouInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdistVisiMergeOrdereou());
		InfoMerger<OrdistInfo, OrdereouInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OrdistInfo> mergeWithUsername(List<OrdistInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilder<OrdistInfo, UsernameInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdistVisiMergeUsername());
		InfoMerger<OrdistInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OrdistInfo> mergeWithOrdarch(List<OrdistInfo> baseInfos, List<OrdarchInfo> selectedInfos) {
		InfoMergerBuilder<OrdistInfo, OrdarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdistVisiMergeOrdarch());
		InfoMerger<OrdistInfo, OrdarchInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OrdistInfo> mergeWithCurrency(List<OrdistInfo> baseInfos, List<CurrencyInfo> selectedInfos) {
		InfoMergerBuilder<OrdistInfo, CurrencyInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdistVisiMergeCurrency());
		InfoMerger<OrdistInfo, CurrencyInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OrdistInfo> mergeWithOrderatus(List<OrdistInfo> baseInfos, List<OrderatusInfo> selectedInfos) {
		InfoMergerBuilder<OrdistInfo, OrderatusInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdistVisiMergeOrderatus());
		InfoMerger<OrdistInfo, OrderatusInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OrdistInfo> mergeToSelect(List<OrdistInfo> baseInfos, List<OrdistInfo> selectedInfos) {
		InfoMergerBuilder<OrdistInfo, OrdistInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdistVisiMergeToSelect());
		InfoMerger<OrdistInfo, OrdistInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
