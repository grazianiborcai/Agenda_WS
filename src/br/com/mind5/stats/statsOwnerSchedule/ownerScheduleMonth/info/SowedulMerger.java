package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonth.info;

import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.info.SowedulagrInfo;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthLive.info.SoweduliveInfo;

public final class SowedulMerger {
	public static List<SowedulInfo> mergeWithStolis(List<SowedulInfo> baseInfos, List<StolisInfo> selectedInfos) {
		InfoMergerBuilder<SowedulInfo, StolisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowedulMergerVisiStolis());
		InfoMerger<SowedulInfo, StolisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SowedulInfo> mergeWithSowedulive(List<SowedulInfo> baseInfos, List<SoweduliveInfo> selectedInfos) {
		InfoMergerBuilder<SowedulInfo, SoweduliveInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowedulMergerVisiSowedulive());
		InfoMerger<SowedulInfo, SoweduliveInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SowedulInfo> mergeWithSowedulagr(List<SowedulInfo> baseInfos, List<SowedulagrInfo> selectedInfos) {
		InfoMergerBuilder<SowedulInfo, SowedulagrInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowedulMergerVisiSowedulagr());
		InfoMerger<SowedulInfo, SowedulagrInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SowedulInfo> mergeWithCalonth(List<SowedulInfo> baseInfos, List<CalonthInfo> selectedInfos) {
		InfoMergerBuilder<SowedulInfo, CalonthInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowedulMergerVisiCalonth());
		InfoMerger<SowedulInfo, CalonthInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
