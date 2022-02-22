package br.com.mind5.stats.statsStoreSchedule.storeScheduleMonth.info;

import java.util.List;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthAggr.info.StedmonagrInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.info.StedmoniveInfo;

public final class StedmonMerger {
	public static List<StedmonInfo> mergeWithStedmonagr(List<StedmonInfo> baseInfos, List<StedmonagrInfo> selectedInfos) {
		InfoMergerBuilder<StedmonInfo, StedmonagrInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StedmonVisiMergeStedmonagr());
		InfoMerger<StedmonInfo, StedmonagrInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StedmonInfo> mergeWithStolis(List<StedmonInfo> baseInfos, List<StolisInfo> selectedInfos) {
		InfoMergerBuilder<StedmonInfo, StolisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StedmonVisiMergeStolis());
		InfoMerger<StedmonInfo, StolisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StedmonInfo> mergeWithStedmonive(List<StedmonInfo> baseInfos, List<StedmoniveInfo> selectedInfos) {
		InfoMergerBuilder<StedmonInfo, StedmoniveInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StedmonVisiMergeStedmonive());
		InfoMerger<StedmonInfo, StedmoniveInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
