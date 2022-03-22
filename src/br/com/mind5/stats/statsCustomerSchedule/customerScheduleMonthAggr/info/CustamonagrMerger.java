package br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthAggr.info;

import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.masterData.state.info.StateInfo;

public final class CustamonagrMerger {
	public static List<CustamonagrInfo> mergeWithCalonth(List<CustamonagrInfo> baseInfos, List<CalonthInfo> selectedInfos) {
		InfoMergerBuilder<CustamonagrInfo, CalonthInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CustamonagrMergerVisiCalonth());
		InfoMerger<CustamonagrInfo, CalonthInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CustamonagrInfo> mergeWithState(List<CustamonagrInfo> baseInfos, List<StateInfo> selectedInfos) {
		InfoMergerBuilder<CustamonagrInfo, StateInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CustamonagrMergerVisiState());
		InfoMerger<CustamonagrInfo, StateInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CustamonagrInfo> mergeToSelect(List<CustamonagrInfo> baseInfos, List<CustamonagrInfo> selectedInfos) {
		InfoMergerBuilder<CustamonagrInfo, CustamonagrInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CustamonagrMergerVisiToSelect());
		InfoMerger<CustamonagrInfo, CustamonagrInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
