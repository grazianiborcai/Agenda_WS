package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;

public final class SowedularchMerger {
	public static List<SowedularchhInfo> mergeToSelect(List<SowedularchhInfo> baseInfos, List<SowedularchhInfo> selectedInfos) {
		InfoMergerBuilder<SowedularchhInfo, SowedularchhInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowedularchVisiMergeToSelect());
		InfoMerger<SowedularchhInfo, SowedularchhInfo> merger = builder.build();
	
		return merger.merge();
	}
}
