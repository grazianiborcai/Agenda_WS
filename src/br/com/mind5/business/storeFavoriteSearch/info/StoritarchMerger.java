package br.com.mind5.business.storeFavoriteSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class StoritarchMerger {
	public static List<StoritarchInfo> mergeToSelect(List<StoritarchInfo> baseInfos, List<StoritarchInfo> selectedInfos) {
		InfoMergerBuilderV3<StoritarchInfo, StoritarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoritarchVisiMergeToSelect());
		InfoMergerV3<StoritarchInfo, StoritarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
