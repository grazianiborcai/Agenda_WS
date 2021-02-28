package br.com.mind5.stats.userOrderYearAggr.info;

import java.util.List;

import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;

public final class StusorygrMerger {
	public static List<StusorygrInfo> mergeToSelect(List<StusorygrInfo> baseInfos, List<StusorygrInfo> selectedInfos) {
		InfoMergerBuilder<StusorygrInfo, StusorygrInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StusorygrVisiMergeToSelect());
		InfoMerger<StusorygrInfo, StusorygrInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
