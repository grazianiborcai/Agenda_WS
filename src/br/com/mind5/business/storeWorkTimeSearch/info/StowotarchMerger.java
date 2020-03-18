package br.com.mind5.business.storeWorkTimeSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class StowotarchMerger {
	public static List<StowotarchInfo> mergeToSelect(List<StowotarchInfo> baseInfos, List<StowotarchInfo> selectedInfos) {
		InfoMergerBuilderV3<StowotarchInfo, StowotarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StowotarchVisiMergeToSelect());
		InfoMergerV3<StowotarchInfo, StowotarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
