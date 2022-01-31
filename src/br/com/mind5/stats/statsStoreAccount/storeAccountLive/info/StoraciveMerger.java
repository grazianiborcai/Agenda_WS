package br.com.mind5.stats.statsStoreAccount.storeAccountLive.info;

import java.util.List;

import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.masterData.state.info.StateInfo;

public final class StoraciveMerger {
	public static List<StoraciveInfo> mergeWithState(List<StoraciveInfo> baseInfos, List<StateInfo> selectedInfos) {
		InfoMergerBuilder<StoraciveInfo, StateInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoraciveVisiMergeState());
		InfoMerger<StoraciveInfo, StateInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StoraciveInfo> mergeToSelect(List<StoraciveInfo> baseInfos, List<StoraciveInfo> selectedInfos) {
		InfoMergerBuilder<StoraciveInfo, StoraciveInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoraciveVisiMergeToSelect());
		InfoMerger<StoraciveInfo, StoraciveInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
