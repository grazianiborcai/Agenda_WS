package br.com.mind5.stats.statsOwnerSchedule.ownerSchedule.info;

import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthLive.info.SoweduliveInfo;

public final class SowedulMerger {
	public static List<SowedulInfo> mergeWithSowedulive(List<SowedulInfo> baseInfos, List<SoweduliveInfo> selectedInfos) {
		InfoMergerBuilder<SowedulInfo, SoweduliveInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowedulVisiMergeSowedulive());
		InfoMerger<SowedulInfo, SoweduliveInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SowedulInfo> mergeWithCalonth(List<SowedulInfo> baseInfos, List<CalonthInfo> selectedInfos) {
		InfoMergerBuilder<SowedulInfo, CalonthInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowedulVisiMergeCalonth());
		InfoMerger<SowedulInfo, CalonthInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
