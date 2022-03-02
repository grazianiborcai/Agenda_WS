package br.com.mind5.stats.statsOwnerUser.ownerUserMonthSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;

public final class SowusarchMerger {
	public static List<SowusarchInfo> mergeToSelect(List<SowusarchInfo> baseInfos, List<SowusarchInfo> selectedInfos) {
		InfoMergerBuilder<SowusarchInfo, SowusarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowusarchMergerVisiToSelect());
		InfoMerger<SowusarchInfo, SowusarchInfo> merger = builder.build();
	
		return merger.merge();
	}
}
