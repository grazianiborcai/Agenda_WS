package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthAggr.info;

import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.masterData.state.info.StateInfo;

public final class SowordagrMerger {
	public static List<SowordagrInfo> mergeWithCalonth(List<SowordagrInfo> baseInfos, List<CalonthInfo> selectedInfos) {
		InfoMergerBuilder<SowordagrInfo, CalonthInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowordagrVisiMergeCalonth());
		InfoMerger<SowordagrInfo, CalonthInfo> merger = builder.build();
	
		return merger.merge();
	}
	
	
	
	public static List<SowordagrInfo> mergeWithState(List<SowordagrInfo> baseInfos, List<StateInfo> selectedInfos) {
		InfoMergerBuilder<SowordagrInfo, StateInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowordagrVisiMergeState());
		InfoMerger<SowordagrInfo, StateInfo> merger = builder.build();
	
		return merger.merge();
	}
	
	
	
	public static List<SowordagrInfo> mergeToSelect(List<SowordagrInfo> baseInfos, List<SowordagrInfo> selectedInfos) {
		InfoMergerBuilder<SowordagrInfo, SowordagrInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowordagrVisiMergeToSelect());
		InfoMerger<SowordagrInfo, SowordagrInfo> merger = builder.build();
	
		return merger.merge();
	}
}
