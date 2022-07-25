package br.com.mind5.stats.statsUserStore.userStoreAggr.info;

import java.util.List;

import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.masterData.currency.info.CurrencyInfo;

public final class StusoraggMerger {
	public static List<StusoraggInfo> mergeWithCurrency(List<StusoraggInfo> baseInfos, List<CurrencyInfo> selectedInfos) {
		InfoMergerBuilder<StusoraggInfo, CurrencyInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StusoraggMergerVisiCurrency());
		InfoMerger<StusoraggInfo, CurrencyInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StusoraggInfo> mergeToSelect(List<StusoraggInfo> baseInfos, List<StusoraggInfo> selectedInfos) {
		InfoMergerBuilder<StusoraggInfo, StusoraggInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StusoraggMergerVisiToSelect());
		InfoMerger<StusoraggInfo, StusoraggInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
