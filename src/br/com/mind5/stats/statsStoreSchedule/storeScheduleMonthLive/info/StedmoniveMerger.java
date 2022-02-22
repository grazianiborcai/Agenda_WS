package br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.info;

import java.util.List;

import br.com.mind5.authorization.storePartitionAuthorization.info.SytotauhInfo;
import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.masterData.state.info.StateInfo;

public final class StedmoniveMerger {
	public static List<StedmoniveInfo> mergeWithSytotauh(List<StedmoniveInfo> baseInfos, List<SytotauhInfo> selectedInfos) {
		InfoMergerBuilder<StedmoniveInfo, SytotauhInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StedmoniveVisiMergeSytotauh());
		InfoMerger<StedmoniveInfo, SytotauhInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StedmoniveInfo> mergeWithCalonth(List<StedmoniveInfo> baseInfos, List<CalonthInfo> selectedInfos) {
		InfoMergerBuilder<StedmoniveInfo, CalonthInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StedmoniveVisiMergeCalonth());
		InfoMerger<StedmoniveInfo, CalonthInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StedmoniveInfo> mergeWithState(List<StedmoniveInfo> baseInfos, List<StateInfo> selectedInfos) {
		InfoMergerBuilder<StedmoniveInfo, StateInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StedmoniveVisiMergeState());
		InfoMerger<StedmoniveInfo, StateInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StedmoniveInfo> mergeToSelect(List<StedmoniveInfo> baseInfos, List<StedmoniveInfo> selectedInfos) {
		InfoMergerBuilder<StedmoniveInfo, StedmoniveInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StedmoniveVisiMergeToSelect());
		InfoMerger<StedmoniveInfo, StedmoniveInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
