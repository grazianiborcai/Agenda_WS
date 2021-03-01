package br.com.mind5.stats.statsUserOrderYear.userOrderYearStgnSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;

public final class StusorygerchMerger {
	public static List<StusorygerchInfo> mergeToSelect(List<StusorygerchInfo> baseInfos, List<StusorygerchInfo> selectedInfos) {
		InfoMergerBuilder<StusorygerchInfo, StusorygerchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StusorygerchVisiMergeToSelect());
		InfoMerger<StusorygerchInfo, StusorygerchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
