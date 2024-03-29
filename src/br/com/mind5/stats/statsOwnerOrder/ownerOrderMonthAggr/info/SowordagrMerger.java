package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthAggr.info;

import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.masterData.state.info.StateInfo;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthSearch.info.SowordarchInfo;

public final class SowordagrMerger {
	public static List<SowordagrInfo> mergeWithSowordarch(List<SowordagrInfo> baseInfos, List<SowordarchInfo> selectedInfos) {
		InfoMergerBuilder<SowordagrInfo, SowordarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowordagrMergerVisiSowordarch());
		InfoMerger<SowordagrInfo, SowordarchInfo> merger = builder.build();
	
		return merger.merge();
	}
	
	
	
	public static List<SowordagrInfo> mergeWithCalonth(List<SowordagrInfo> baseInfos, List<CalonthInfo> selectedInfos) {
		InfoMergerBuilder<SowordagrInfo, CalonthInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowordagrMergerVisiCalonth());
		InfoMerger<SowordagrInfo, CalonthInfo> merger = builder.build();
	
		return merger.merge();
	}
	
	
	
	public static List<SowordagrInfo> mergeWithState(List<SowordagrInfo> baseInfos, List<StateInfo> selectedInfos) {
		InfoMergerBuilder<SowordagrInfo, StateInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowordagrMergerVisiState());
		InfoMerger<SowordagrInfo, StateInfo> merger = builder.build();
	
		return merger.merge();
	}
	
	
	
	public static List<SowordagrInfo> mergeToSelect(List<SowordagrInfo> baseInfos, List<SowordagrInfo> selectedInfos) {
		InfoMergerBuilder<SowordagrInfo, SowordagrInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowordagrMergerVisiToSelect());
		InfoMerger<SowordagrInfo, SowordagrInfo> merger = builder.build();
	
		return merger.merge();
	}
}
