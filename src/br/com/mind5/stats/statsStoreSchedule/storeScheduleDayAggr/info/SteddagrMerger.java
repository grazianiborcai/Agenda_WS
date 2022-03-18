package br.com.mind5.stats.statsStoreSchedule.storeScheduleDayAggr.info;

import java.util.List;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.masterData.state.info.StateInfo;

public final class SteddagrMerger {
	public static List<SteddagrInfo> mergeWithCalate(List<SteddagrInfo> baseInfos, List<CalateInfo> selectedInfos) {
		InfoMergerBuilder<SteddagrInfo, CalateInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SteddagrMergerVisiCalate());
		InfoMerger<SteddagrInfo, CalateInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SteddagrInfo> mergeWithState(List<SteddagrInfo> baseInfos, List<StateInfo> selectedInfos) {
		InfoMergerBuilder<SteddagrInfo, StateInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SteddagrMergerVisiState());
		InfoMerger<SteddagrInfo, StateInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SteddagrInfo> mergeToSelect(List<SteddagrInfo> baseInfos, List<SteddagrInfo> selectedInfos) {
		InfoMergerBuilder<SteddagrInfo, SteddagrInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SteddagrMergerVisiToSelect());
		InfoMerger<SteddagrInfo, SteddagrInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
