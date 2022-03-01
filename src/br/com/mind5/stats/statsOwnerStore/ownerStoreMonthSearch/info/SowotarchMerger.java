package br.com.mind5.stats.statsOwnerStore.ownerStoreMonthSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;

public final class SowotarchMerger {
	public static List<SowotarchInfo> mergeToSelect(List<SowotarchInfo> baseInfos, List<SowotarchInfo> selectedInfos) {
		InfoMergerBuilder<SowotarchInfo, SowotarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowotarchMergerVisiToSelect());
		InfoMerger<SowotarchInfo, SowotarchInfo> merger = builder.build();
	
		return merger.merge();
	}
}
