package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthLive.info;

import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.masterData.month.info.MonthInfo;
import br.com.mind5.masterData.state.info.StateInfo;

public final class SoweduliveMerger {
	public static List<SoweduliveInfo> mergeWithCalonth(List<SoweduliveInfo> baseInfos, List<CalonthInfo> selectedInfos) {
		InfoMergerBuilder<SoweduliveInfo, CalonthInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SoweduliveMergerVisiCalonth());
		InfoMerger<SoweduliveInfo, CalonthInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SoweduliveInfo> mergeWithMonth(List<SoweduliveInfo> baseInfos, List<MonthInfo> selectedInfos) {
		InfoMergerBuilder<SoweduliveInfo, MonthInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SoweduliveMergerVisiMonth());
		InfoMerger<SoweduliveInfo, MonthInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SoweduliveInfo> mergeWithState(List<SoweduliveInfo> baseInfos, List<StateInfo> selectedInfos) {
		InfoMergerBuilder<SoweduliveInfo, StateInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SoweduliveMergerVisiState());
		InfoMerger<SoweduliveInfo, StateInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SoweduliveInfo> mergeToSelect(List<SoweduliveInfo> baseInfos, List<SoweduliveInfo> selectedInfos) {
		InfoMergerBuilder<SoweduliveInfo, SoweduliveInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SoweduliveMergerVisiToSelect());
		InfoMerger<SoweduliveInfo, SoweduliveInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
