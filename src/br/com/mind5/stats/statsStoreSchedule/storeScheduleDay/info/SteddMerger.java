package br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.info;

import java.util.List;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayAggr.info.SteddagrInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayLive.info.SteddiveInfo;

public final class SteddMerger {
	public static List<SteddInfo> mergeWithSteddagr(List<SteddInfo> baseInfos, List<SteddagrInfo> selectedInfos) {
		InfoMergerBuilder<SteddInfo, SteddagrInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SteddMergerVisiSteddagr());
		InfoMerger<SteddInfo, SteddagrInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SteddInfo> mergeWithStolis(List<SteddInfo> baseInfos, List<StolisInfo> selectedInfos) {
		InfoMergerBuilder<SteddInfo, StolisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SteddMergerVisiStolis());
		InfoMerger<SteddInfo, StolisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SteddInfo> mergeWithSteddive(List<SteddInfo> baseInfos, List<SteddiveInfo> selectedInfos) {
		InfoMergerBuilder<SteddInfo, SteddiveInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SteddMergerVisiSteddive());
		InfoMerger<SteddInfo, SteddiveInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SteddInfo> mergeWithCalate(List<SteddInfo> baseInfos, List<CalateInfo> selectedInfos) {
		InfoMergerBuilder<SteddInfo, CalateInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SteddMergerVisiCalate());
		InfoMerger<SteddInfo, CalateInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
