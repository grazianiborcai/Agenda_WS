package br.com.mind5.stats.statsStoreOrder.storeOrderMonthLive.info;

import java.util.List;

import br.com.mind5.authorization.storePartitionAuthorization.info.SytotauhInfo;
import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.masterData.state.info.StateInfo;

public final class StoroniveMerger {
	public static List<StoroniveInfo> mergeWithSytotauh(List<StoroniveInfo> baseInfos, List<SytotauhInfo> selectedInfos) {
		InfoMergerBuilder<StoroniveInfo, SytotauhInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoroniveVisiMergeSytotauh());
		InfoMerger<StoroniveInfo, SytotauhInfo> merger = builder.build();
	
		return merger.merge();
	}
	
	
	
	public static List<StoroniveInfo> mergeWithCalonth(List<StoroniveInfo> baseInfos, List<CalonthInfo> selectedInfos) {
		InfoMergerBuilder<StoroniveInfo, CalonthInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoroniveVisiMergeCalonth());
		InfoMerger<StoroniveInfo, CalonthInfo> merger = builder.build();
	
		return merger.merge();
	}
	
	
	
	public static List<StoroniveInfo> mergeWithState(List<StoroniveInfo> baseInfos, List<StateInfo> selectedInfos) {
		InfoMergerBuilder<StoroniveInfo, StateInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoroniveVisiMergeState());
		InfoMerger<StoroniveInfo, StateInfo> merger = builder.build();
	
		return merger.merge();
	}
	
	
	
	public static List<StoroniveInfo> mergeToSelect(List<StoroniveInfo> baseInfos, List<StoroniveInfo> selectedInfos) {
		InfoMergerBuilder<StoroniveInfo, StoroniveInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoroniveVisiMergeToSelect());
		InfoMerger<StoroniveInfo, StoroniveInfo> merger = builder.build();
	
		return merger.merge();
	}
}
