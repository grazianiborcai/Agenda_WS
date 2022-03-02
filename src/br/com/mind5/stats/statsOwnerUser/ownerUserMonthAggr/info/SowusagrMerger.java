package br.com.mind5.stats.statsOwnerUser.ownerUserMonthAggr.info;

import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.masterData.state.info.StateInfo;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthSearch.info.SowusarchInfo;

public final class SowusagrMerger {
	public static List<SowusagrInfo> mergeWithSowusarch(List<SowusagrInfo> baseInfos, List<SowusarchInfo> selectedInfos) {
		InfoMergerBuilder<SowusagrInfo, SowusarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowusagrMergerVisiSowusarch());
		InfoMerger<SowusagrInfo, SowusarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SowusagrInfo> mergeWithCalonth(List<SowusagrInfo> baseInfos, List<CalonthInfo> selectedInfos) {
		InfoMergerBuilder<SowusagrInfo, CalonthInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowusagrMergerVisiCalonth());
		InfoMerger<SowusagrInfo, CalonthInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SowusagrInfo> mergeWithState(List<SowusagrInfo> baseInfos, List<StateInfo> selectedInfos) {
		InfoMergerBuilder<SowusagrInfo, StateInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowusagrMergerVisiState());
		InfoMerger<SowusagrInfo, StateInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SowusagrInfo> mergeToSelect(List<SowusagrInfo> baseInfos, List<SowusagrInfo> selectedInfos) {
		InfoMergerBuilder<SowusagrInfo, SowusagrInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowusagrMergerVisiToSelect());
		InfoMerger<SowusagrInfo, SowusagrInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
