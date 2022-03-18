package br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthAggr.info;

import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.masterData.state.info.StateInfo;

public final class StedmonagrMerger {
	public static List<StedmonagrInfo> mergeWithCalonth(List<StedmonagrInfo> baseInfos, List<CalonthInfo> selectedInfos) {
		InfoMergerBuilder<StedmonagrInfo, CalonthInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StedmonagrMergerVisiCalonth());
		InfoMerger<StedmonagrInfo, CalonthInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StedmonagrInfo> mergeWithState(List<StedmonagrInfo> baseInfos, List<StateInfo> selectedInfos) {
		InfoMergerBuilder<StedmonagrInfo, StateInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StedmonagrMergerVisiState());
		InfoMerger<StedmonagrInfo, StateInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StedmonagrInfo> mergeToSelect(List<StedmonagrInfo> baseInfos, List<StedmonagrInfo> selectedInfos) {
		InfoMergerBuilder<StedmonagrInfo, StedmonagrInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StedmonagrMergerVisiToSelect());
		InfoMerger<StedmonagrInfo, StedmonagrInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
