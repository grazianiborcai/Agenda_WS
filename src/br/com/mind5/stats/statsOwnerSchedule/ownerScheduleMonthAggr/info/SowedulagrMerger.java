package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.info;

import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.masterData.state.info.StateInfo;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.info.SowedularchInfo;

public final class SowedulagrMerger {
	public static List<SowedulagrInfo> mergeWithSowedularch(List<SowedulagrInfo> baseInfos, List<SowedularchInfo> selectedInfos) {
		InfoMergerBuilder<SowedulagrInfo, SowedularchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowedulagrVisiMergeSowedularch());
		InfoMerger<SowedulagrInfo, SowedularchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SowedulagrInfo> mergeWithCalonth(List<SowedulagrInfo> baseInfos, List<CalonthInfo> selectedInfos) {
		InfoMergerBuilder<SowedulagrInfo, CalonthInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowedulagrVisiMergeCalonth());
		InfoMerger<SowedulagrInfo, CalonthInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SowedulagrInfo> mergeWithState(List<SowedulagrInfo> baseInfos, List<StateInfo> selectedInfos) {
		InfoMergerBuilder<SowedulagrInfo, StateInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowedulagrVisiMergeState());
		InfoMerger<SowedulagrInfo, StateInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SowedulagrInfo> mergeToSelect(List<SowedulagrInfo> baseInfos, List<SowedulagrInfo> selectedInfos) {
		InfoMergerBuilder<SowedulagrInfo, SowedulagrInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowedulagrVisiMergeToSelect());
		InfoMerger<SowedulagrInfo, SowedulagrInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
