package br.com.mind5.business.storeLeaveDateSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;


public final class StolarchMerger {
	public static List<StolarchInfo> mergeToSelect(List<StolarchInfo> baseInfos, List<StolarchInfo> selectedInfos) {
		InfoMergerBuilder<StolarchInfo, StolarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StolarchMergerVisiToSelect());
		InfoMerger<StolarchInfo, StolarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
