package br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthLive.info;

import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.masterData.state.info.StateInfo;

public final class CustamoniveMerger {
	public static List<CustamoniveInfo> mergeWithCalonth(List<CustamoniveInfo> baseInfos, List<CalonthInfo> selectedInfos) {
		InfoMergerBuilder<CustamoniveInfo, CalonthInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CustamoniveMergerVisiCalonth());
		InfoMerger<CustamoniveInfo, CalonthInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CustamoniveInfo> mergeWithState(List<CustamoniveInfo> baseInfos, List<StateInfo> selectedInfos) {
		InfoMergerBuilder<CustamoniveInfo, StateInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CustamoniveMergerVisiState());
		InfoMerger<CustamoniveInfo, StateInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CustamoniveInfo> mergeToSelect(List<CustamoniveInfo> baseInfos, List<CustamoniveInfo> selectedInfos) {
		InfoMergerBuilder<CustamoniveInfo, CustamoniveInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CustamoniveMergerVisiToSelect());
		InfoMerger<CustamoniveInfo, CustamoniveInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
