package br.com.mind5.stats.statsUserOrderYear.userOrderYearLiveSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;

public final class StusorylirchMerger {
	public static List<StusorylirchInfo> mergeToSelect(List<StusorylirchInfo> baseInfos, List<StusorylirchInfo> selectedInfos) {
		InfoMergerBuilder<StusorylirchInfo, StusorylirchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StusorylirchVisiMergeToSelect());
		InfoMerger<StusorylirchInfo, StusorylirchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
