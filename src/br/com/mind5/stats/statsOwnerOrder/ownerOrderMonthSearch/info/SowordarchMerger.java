package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;

public final class SowordarchMerger {
	public static List<SowordarchInfo> mergeToSelect(List<SowordarchInfo> baseInfos, List<SowordarchInfo> selectedInfos) {
		InfoMergerBuilder<SowordarchInfo, SowordarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowordarchVisiMergeToSelect());
		InfoMerger<SowordarchInfo, SowordarchInfo> merger = builder.build();
	
		return merger.merge();
	}
}
