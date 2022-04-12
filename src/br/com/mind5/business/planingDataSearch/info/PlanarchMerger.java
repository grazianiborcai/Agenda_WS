package br.com.mind5.business.planingDataSearch.info;

import java.util.List;

import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class PlanarchMerger {		
	public static List<PlanarchInfo> mergeWithPlanata(List<PlanarchInfo> baseInfos, List<PlanataInfo> selectedInfos) {
		InfoMergerBuilder<PlanarchInfo, PlanataInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PlanarchMergerVisiPlanata());
		InfoMerger<PlanarchInfo, PlanataInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
