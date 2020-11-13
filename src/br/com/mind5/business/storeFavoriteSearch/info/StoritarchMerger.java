package br.com.mind5.business.storeFavoriteSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class StoritarchMerger {
	public static List<StoritarchInfo> mergeToSelect(List<StoritarchInfo> baseInfos, List<StoritarchInfo> selectedInfos) {
		InfoMergerBuilder<StoritarchInfo, StoritarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoritarchVisiMergeToSelect());
		InfoMerger<StoritarchInfo, StoritarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
