package br.com.mind5.stats.statsUserOrderYear.userOrderYearAggrSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;

public final class StusorygrarchMerger {
	public static List<StusorygrarchInfo> mergeToSelect(List<StusorygrarchInfo> baseInfos, List<StusorygrarchInfo> selectedInfos) {
		InfoMergerBuilder<StusorygrarchInfo, StusorygrarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StusorygrarchVisiMergeToSelect());
		InfoMerger<StusorygrarchInfo, StusorygrarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
