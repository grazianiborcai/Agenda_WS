package br.com.mind5.stats.statsOwnerSale.ownerSaleAggr.info;

import java.util.List;

import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.masterData.state.info.StateInfo;

public final class SowalagrMerger {
	public static List<SowalagrInfo> mergeWithState(List<SowalagrInfo> baseInfos, List<StateInfo> selectedInfos) {
		InfoMergerBuilder<SowalagrInfo, StateInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowalagrMergerVisiState());
		InfoMerger<SowalagrInfo, StateInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SowalagrInfo> mergeToSelect(List<SowalagrInfo> baseInfos, List<SowalagrInfo> selectedInfos) {
		InfoMergerBuilder<SowalagrInfo, SowalagrInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowalagrMergerVisiToSelect());
		InfoMerger<SowalagrInfo, SowalagrInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
