package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;

public final class SowedularchMerger {
	public static List<SowedularchInfo> mergeToSelect(List<SowedularchInfo> baseInfos, List<SowedularchInfo> selectedInfos) {
		InfoMergerBuilder<SowedularchInfo, SowedularchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowedularchMergerVisiToSelect());
		InfoMerger<SowedularchInfo, SowedularchInfo> merger = builder.build();
	
		return merger.merge();
	}
}
