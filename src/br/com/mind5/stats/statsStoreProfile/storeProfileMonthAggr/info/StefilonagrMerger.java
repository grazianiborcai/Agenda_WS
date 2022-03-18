package br.com.mind5.stats.statsStoreProfile.storeProfileMonthAggr.info;

import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;

public final class StefilonagrMerger {
	public static List<StefilonagrInfo> mergeWithCalonth(List<StefilonagrInfo> baseInfos, List<CalonthInfo> selectedInfos) {
		InfoMergerBuilder<StefilonagrInfo, CalonthInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StefilonagrMergerVisiCalonth());
		InfoMerger<StefilonagrInfo, CalonthInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StefilonagrInfo> mergeToSelect(List<StefilonagrInfo> baseInfos, List<StefilonagrInfo> selectedInfos) {
		InfoMergerBuilder<StefilonagrInfo, StefilonagrInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StefilonagrMergerVisiToSelect());
		InfoMerger<StefilonagrInfo, StefilonagrInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
