package br.com.mind5.business.planingDataSearch.info;

import java.util.List;

import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class PlanarchMerger {		
	public static List<PlanarchInfo> mergeWithPlanata(List<PlanarchInfo> baseInfos, List<PlanataInfo> selectedInfos) {
		InfoMergerBuilderV3<PlanarchInfo, PlanataInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PlanarchVisiMergePlanata());
		InfoMergerV3<PlanarchInfo, PlanataInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
