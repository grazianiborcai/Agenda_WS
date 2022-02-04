package br.com.mind5.stats.statsUserAccount.userAccountLive.info;

import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.masterData.month.info.MonthInfo;
import br.com.mind5.masterData.state.info.StateInfo;

public final class UseraciveMerger {
	public static List<UseraciveInfo> mergeWithCalonth(List<UseraciveInfo> baseInfos, List<CalonthInfo> selectedInfos) {
		InfoMergerBuilder<UseraciveInfo, CalonthInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new UseraciveVisiMergeCalonth());
		InfoMerger<UseraciveInfo, CalonthInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<UseraciveInfo> mergeWithMonth(List<UseraciveInfo> baseInfos, List<MonthInfo> selectedInfos) {
		InfoMergerBuilder<UseraciveInfo, MonthInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new UseraciveVisiMergeMonth());
		InfoMerger<UseraciveInfo, MonthInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<UseraciveInfo> mergeWithState(List<UseraciveInfo> baseInfos, List<StateInfo> selectedInfos) {
		InfoMergerBuilder<UseraciveInfo, StateInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new UseraciveVisiMergeState());
		InfoMerger<UseraciveInfo, StateInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<UseraciveInfo> mergeToSelect(List<UseraciveInfo> baseInfos, List<UseraciveInfo> selectedInfos) {
		InfoMergerBuilder<UseraciveInfo, UseraciveInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new UseraciveVisiMergeToSelect());
		InfoMerger<UseraciveInfo, UseraciveInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
