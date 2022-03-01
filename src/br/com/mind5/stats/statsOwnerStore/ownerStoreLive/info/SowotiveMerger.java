package br.com.mind5.stats.statsOwnerStore.ownerStoreLive.info;

import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.masterData.month.info.MonthInfo;
import br.com.mind5.masterData.state.info.StateInfo;

public final class SowotiveMerger {
	public static List<SowotiveInfo> mergeWithCalonth(List<SowotiveInfo> baseInfos, List<CalonthInfo> selectedInfos) {
		InfoMergerBuilder<SowotiveInfo, CalonthInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowotiveMergerVisiCalonth());
		InfoMerger<SowotiveInfo, CalonthInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SowotiveInfo> mergeWithMonth(List<SowotiveInfo> baseInfos, List<MonthInfo> selectedInfos) {
		InfoMergerBuilder<SowotiveInfo, MonthInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowotiveMergerVisiMonth());
		InfoMerger<SowotiveInfo, MonthInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SowotiveInfo> mergeWithState(List<SowotiveInfo> baseInfos, List<StateInfo> selectedInfos) {
		InfoMergerBuilder<SowotiveInfo, StateInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowotiveMergerVisiState());
		InfoMerger<SowotiveInfo, StateInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SowotiveInfo> mergeToSelect(List<SowotiveInfo> baseInfos, List<SowotiveInfo> selectedInfos) {
		InfoMergerBuilder<SowotiveInfo, SowotiveInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowotiveMergerVisiToSelect());
		InfoMerger<SowotiveInfo, SowotiveInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
