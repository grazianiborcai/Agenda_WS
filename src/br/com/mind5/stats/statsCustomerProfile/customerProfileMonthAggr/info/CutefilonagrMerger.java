package br.com.mind5.stats.statsCustomerProfile.customerProfileMonthAggr.info;

import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;

public final class CutefilonagrMerger {
	public static List<CutefilonagrInfo> mergeWithCalonth(List<CutefilonagrInfo> baseInfos, List<CalonthInfo> selectedInfos) {
		InfoMergerBuilder<CutefilonagrInfo, CalonthInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CutefilonagrMergerVisiCalonth());
		InfoMerger<CutefilonagrInfo, CalonthInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CutefilonagrInfo> mergeToSelect(List<CutefilonagrInfo> baseInfos, List<CutefilonagrInfo> selectedInfos) {
		InfoMergerBuilder<CutefilonagrInfo, CutefilonagrInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CutefilonagrMergerVisiToSelect());
		InfoMerger<CutefilonagrInfo, CutefilonagrInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
