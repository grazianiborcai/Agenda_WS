package br.com.mind5.stats.statsStoreOrder.storeOrderMonthAggr.info;

import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.masterData.state.info.StateInfo;

public final class StoronagrMerger {
	public static List<StoronagrInfo> mergeWithCalonth(List<StoronagrInfo> baseInfos, List<CalonthInfo> selectedInfos) {
		InfoMergerBuilder<StoronagrInfo, CalonthInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoronagrVisiMergeCalonth());
		InfoMerger<StoronagrInfo, CalonthInfo> merger = builder.build();
	
		return merger.merge();
	}
	
	
	
	public static List<StoronagrInfo> mergeWithState(List<StoronagrInfo> baseInfos, List<StateInfo> selectedInfos) {
		InfoMergerBuilder<StoronagrInfo, StateInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoronagrVisiMergeState());
		InfoMerger<StoronagrInfo, StateInfo> merger = builder.build();
	
		return merger.merge();
	}
	
	
	
	public static List<StoronagrInfo> mergeToSelect(List<StoronagrInfo> baseInfos, List<StoronagrInfo> selectedInfos) {
		InfoMergerBuilder<StoronagrInfo, StoronagrInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoronagrVisiMergeToSelect());
		InfoMerger<StoronagrInfo, StoronagrInfo> merger = builder.build();
	
		return merger.merge();
	}
}
