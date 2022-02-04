package br.com.mind5.stats.statsUserAccount.userAccountLive.info;

import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.masterData.month.info.MonthInfo;
import br.com.mind5.masterData.state.info.StateInfo;

public final class SuseraciveMerger {
	public static List<SuseraciveInfo> mergeWithCalonth(List<SuseraciveInfo> baseInfos, List<CalonthInfo> selectedInfos) {
		InfoMergerBuilder<SuseraciveInfo, CalonthInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SuseraciveVisiMergeCalonth());
		InfoMerger<SuseraciveInfo, CalonthInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SuseraciveInfo> mergeWithMonth(List<SuseraciveInfo> baseInfos, List<MonthInfo> selectedInfos) {
		InfoMergerBuilder<SuseraciveInfo, MonthInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SuseraciveVisiMergeMonth());
		InfoMerger<SuseraciveInfo, MonthInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SuseraciveInfo> mergeWithState(List<SuseraciveInfo> baseInfos, List<StateInfo> selectedInfos) {
		InfoMergerBuilder<SuseraciveInfo, StateInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SuseraciveVisiMergeState());
		InfoMerger<SuseraciveInfo, StateInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SuseraciveInfo> mergeToSelect(List<SuseraciveInfo> baseInfos, List<SuseraciveInfo> selectedInfos) {
		InfoMergerBuilder<SuseraciveInfo, SuseraciveInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SuseraciveVisiMergeToSelect());
		InfoMerger<SuseraciveInfo, SuseraciveInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
