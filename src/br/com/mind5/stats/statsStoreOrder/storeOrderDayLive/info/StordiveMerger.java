package br.com.mind5.stats.statsStoreOrder.storeOrderDayLive.info;

import java.util.List;

import br.com.mind5.authorization.storePartitionAuthorization.info.SytotauhInfo;
import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.masterData.state.info.StateInfo;

public final class StordiveMerger {
	public static List<StordiveInfo> mergeWithSytotauh(List<StordiveInfo> baseInfos, List<SytotauhInfo> selectedInfos) {
		InfoMergerBuilder<StordiveInfo, SytotauhInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StordiveVisiMergeSytotauh());
		InfoMerger<StordiveInfo, SytotauhInfo> merger = builder.build();
	
		return merger.merge();
	}
	
	
	
	public static List<StordiveInfo> mergeWithCalate(List<StordiveInfo> baseInfos, List<CalateInfo> selectedInfos) {
		InfoMergerBuilder<StordiveInfo, CalateInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StordiveVisiMergeCalate());
		InfoMerger<StordiveInfo, CalateInfo> merger = builder.build();
	
		return merger.merge();
	}
	
	
	
	public static List<StordiveInfo> mergeWithState(List<StordiveInfo> baseInfos, List<StateInfo> selectedInfos) {
		InfoMergerBuilder<StordiveInfo, StateInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StordiveVisiMergeState());
		InfoMerger<StordiveInfo, StateInfo> merger = builder.build();
	
		return merger.merge();
	}
	
	
	
	public static List<StordiveInfo> mergeToSelect(List<StordiveInfo> baseInfos, List<StordiveInfo> selectedInfos) {
		InfoMergerBuilder<StordiveInfo, StordiveInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StordiveVisiMergeToSelect());
		InfoMerger<StordiveInfo, StordiveInfo> merger = builder.build();
	
		return merger.merge();
	}
}
