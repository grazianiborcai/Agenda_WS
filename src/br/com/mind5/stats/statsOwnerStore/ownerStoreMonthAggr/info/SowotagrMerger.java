package br.com.mind5.stats.statsOwnerStore.ownerStoreMonthAggr.info;

import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.masterData.state.info.StateInfo;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthSearch.info.SowotarchInfo;

public final class SowotagrMerger {
	public static List<SowotagrInfo> mergeWithSowotarch(List<SowotagrInfo> baseInfos, List<SowotarchInfo> selectedInfos) {
		InfoMergerBuilder<SowotagrInfo, SowotarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowotagrMergerVisiSowotarch());
		InfoMerger<SowotagrInfo, SowotarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SowotagrInfo> mergeWithCalonth(List<SowotagrInfo> baseInfos, List<CalonthInfo> selectedInfos) {
		InfoMergerBuilder<SowotagrInfo, CalonthInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowotagrMergerVisiCalonth());
		InfoMerger<SowotagrInfo, CalonthInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SowotagrInfo> mergeWithState(List<SowotagrInfo> baseInfos, List<StateInfo> selectedInfos) {
		InfoMergerBuilder<SowotagrInfo, StateInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowotagrMergerVisiState());
		InfoMerger<SowotagrInfo, StateInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SowotagrInfo> mergeToSelect(List<SowotagrInfo> baseInfos, List<SowotagrInfo> selectedInfos) {
		InfoMergerBuilder<SowotagrInfo, SowotagrInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowotagrMergerVisiToSelect());
		InfoMerger<SowotagrInfo, SowotagrInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
