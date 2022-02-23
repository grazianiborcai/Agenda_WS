package br.com.mind5.stats.statsStoreOrder.storeOrderDayAggr.info;

import java.util.List;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.masterData.state.info.StateInfo;

public final class StordagrMerger {
	public static List<StordagrInfo> mergeWithCalate(List<StordagrInfo> baseInfos, List<CalateInfo> selectedInfos) {
		InfoMergerBuilder<StordagrInfo, CalateInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StordagrVisiMergeCalate());
		InfoMerger<StordagrInfo, CalateInfo> merger = builder.build();
	
		return merger.merge();
	}
	
	
	
	public static List<StordagrInfo> mergeWithState(List<StordagrInfo> baseInfos, List<StateInfo> selectedInfos) {
		InfoMergerBuilder<StordagrInfo, StateInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StordagrVisiMergeState());
		InfoMerger<StordagrInfo, StateInfo> merger = builder.build();
	
		return merger.merge();
	}
	
	
	
	public static List<StordagrInfo> mergeToSelect(List<StordagrInfo> baseInfos, List<StordagrInfo> selectedInfos) {
		InfoMergerBuilder<StordagrInfo, StordagrInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StordagrVisiMergeToSelect());
		InfoMerger<StordagrInfo, StordagrInfo> merger = builder.build();
	
		return merger.merge();
	}
}
