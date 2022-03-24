package br.com.mind5.business.storeWorkTimeRange.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class StoworgMerger {
	public static List<StoworgInfo> mergeToSelect(List<StoworgInfo> baseInfos, List<StoworgInfo> selectedInfos) {
		InfoMergerBuilder<StoworgInfo, StoworgInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoworgMergerVisiToSelect());
		InfoMerger<StoworgInfo, StoworgInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
