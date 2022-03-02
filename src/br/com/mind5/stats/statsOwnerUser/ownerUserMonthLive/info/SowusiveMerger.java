package br.com.mind5.stats.statsOwnerUser.ownerUserMonthLive.info;

import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.masterData.month.info.MonthInfo;
import br.com.mind5.masterData.state.info.StateInfo;

public final class SowusiveMerger {
	public static List<SowusiveInfo> mergeWithCalonth(List<SowusiveInfo> baseInfos, List<CalonthInfo> selectedInfos) {
		InfoMergerBuilder<SowusiveInfo, CalonthInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowusiveMergerVisiCalonth());
		InfoMerger<SowusiveInfo, CalonthInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SowusiveInfo> mergeWithMonth(List<SowusiveInfo> baseInfos, List<MonthInfo> selectedInfos) {
		InfoMergerBuilder<SowusiveInfo, MonthInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowusiveMergerVisiMonth());
		InfoMerger<SowusiveInfo, MonthInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SowusiveInfo> mergeWithState(List<SowusiveInfo> baseInfos, List<StateInfo> selectedInfos) {
		InfoMergerBuilder<SowusiveInfo, StateInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowusiveMergerVisiState());
		InfoMerger<SowusiveInfo, StateInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SowusiveInfo> mergeToSelect(List<SowusiveInfo> baseInfos, List<SowusiveInfo> selectedInfos) {
		InfoMergerBuilder<SowusiveInfo, SowusiveInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowusiveMergerVisiToSelect());
		InfoMerger<SowusiveInfo, SowusiveInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
