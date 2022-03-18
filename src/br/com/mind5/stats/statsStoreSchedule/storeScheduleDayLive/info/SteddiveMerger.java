package br.com.mind5.stats.statsStoreSchedule.storeScheduleDayLive.info;

import java.util.List;

import br.com.mind5.authorization.storePartitionAuthorization.info.SytotauhInfo;
import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.masterData.state.info.StateInfo;

public final class SteddiveMerger {
	public static List<SteddiveInfo> mergeWithSytotauh(List<SteddiveInfo> baseInfos, List<SytotauhInfo> selectedInfos) {
		InfoMergerBuilder<SteddiveInfo, SytotauhInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SteddiveMergerVisiSytotauh());
		InfoMerger<SteddiveInfo, SytotauhInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SteddiveInfo> mergeWithCalate(List<SteddiveInfo> baseInfos, List<CalateInfo> selectedInfos) {
		InfoMergerBuilder<SteddiveInfo, CalateInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SteddiveMergerVisiCalate());
		InfoMerger<SteddiveInfo, CalateInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SteddiveInfo> mergeWithState(List<SteddiveInfo> baseInfos, List<StateInfo> selectedInfos) {
		InfoMergerBuilder<SteddiveInfo, StateInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SteddiveMergerVisiState());
		InfoMerger<SteddiveInfo, StateInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SteddiveInfo> mergeToSelect(List<SteddiveInfo> baseInfos, List<SteddiveInfo> selectedInfos) {
		InfoMergerBuilder<SteddiveInfo, SteddiveInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SteddiveMergerVisiToSelect());
		InfoMerger<SteddiveInfo, SteddiveInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
