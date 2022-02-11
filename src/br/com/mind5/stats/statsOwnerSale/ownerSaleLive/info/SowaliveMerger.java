package br.com.mind5.stats.statsOwnerSale.ownerSaleLive.info;

import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.masterData.month.info.MonthInfo;
import br.com.mind5.masterData.state.info.StateInfo;

public final class SowaliveMerger {
	public static List<SowaliveInfo> mergeWithCalonth(List<SowaliveInfo> baseInfos, List<CalonthInfo> selectedInfos) {
		InfoMergerBuilder<SowaliveInfo, CalonthInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowaliveVisiMergeCalonth());
		InfoMerger<SowaliveInfo, CalonthInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SowaliveInfo> mergeWithMonth(List<SowaliveInfo> baseInfos, List<MonthInfo> selectedInfos) {
		InfoMergerBuilder<SowaliveInfo, MonthInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowaliveVisiMergeMonth());
		InfoMerger<SowaliveInfo, MonthInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SowaliveInfo> mergeWithState(List<SowaliveInfo> baseInfos, List<StateInfo> selectedInfos) {
		InfoMergerBuilder<SowaliveInfo, StateInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowaliveVisiMergeState());
		InfoMerger<SowaliveInfo, StateInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SowaliveInfo> mergeToSelect(List<SowaliveInfo> baseInfos, List<SowaliveInfo> selectedInfos) {
		InfoMergerBuilder<SowaliveInfo, SowaliveInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowaliveVisiMergeToSelect());
		InfoMerger<SowaliveInfo, SowaliveInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
