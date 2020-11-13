package br.com.mind5.business.storeWorkTimeSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class StowotarchMerger {
	public static List<StowotarchInfo> mergeToSelect(List<StowotarchInfo> baseInfos, List<StowotarchInfo> selectedInfos) {
		InfoMergerBuilder<StowotarchInfo, StowotarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StowotarchVisiMergeToSelect());
		InfoMerger<StowotarchInfo, StowotarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
