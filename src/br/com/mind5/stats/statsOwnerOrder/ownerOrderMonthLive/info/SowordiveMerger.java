package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthLive.info;

import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.masterData.month.info.MonthInfo;
import br.com.mind5.masterData.state.info.StateInfo;

public final class SowordiveMerger {
	public static List<SowordiveInfo> mergeWithCalonth(List<SowordiveInfo> baseInfos, List<CalonthInfo> selectedInfos) {
		InfoMergerBuilder<SowordiveInfo, CalonthInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowordiveVisiMergeCalonth());
		InfoMerger<SowordiveInfo, CalonthInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SowordiveInfo> mergeWithMonth(List<SowordiveInfo> baseInfos, List<MonthInfo> selectedInfos) {
		InfoMergerBuilder<SowordiveInfo, MonthInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowordiveVisiMergeMonth());
		InfoMerger<SowordiveInfo, MonthInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SowordiveInfo> mergeWithState(List<SowordiveInfo> baseInfos, List<StateInfo> selectedInfos) {
		InfoMergerBuilder<SowordiveInfo, StateInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowordiveVisiMergeState());
		InfoMerger<SowordiveInfo, StateInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SowordiveInfo> mergeToSelect(List<SowordiveInfo> baseInfos, List<SowordiveInfo> selectedInfos) {
		InfoMergerBuilder<SowordiveInfo, SowordiveInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowordiveVisiMergeToSelect());
		InfoMerger<SowordiveInfo, SowordiveInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
