package br.com.mind5.business.storeLeaveDateSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;


public final class StolarchMerger {
	public static List<StolarchInfo> mergeToSelect(List<StolarchInfo> baseInfos, List<StolarchInfo> selectedInfos) {
		InfoMergerBuilderV3<StolarchInfo, StolarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StolarchVisiMergeToSelect());
		InfoMergerV3<StolarchInfo, StolarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
