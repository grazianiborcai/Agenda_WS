package br.com.mind5.business.storeWorkTimeRange.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class StoworgMerger {
	public static List<StoworgInfo> mergeToSelect(List<StoworgInfo> baseInfos, List<StoworgInfo> selectedInfos) {
		InfoMergerBuilderV3<StoworgInfo, StoworgInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoworgVisiMergeToSelect());
		InfoMergerV3<StoworgInfo, StoworgInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
