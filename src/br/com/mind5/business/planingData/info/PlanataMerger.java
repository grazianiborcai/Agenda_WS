package br.com.mind5.business.planingData.info;

import java.util.List;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class PlanataMerger {		
	public static List<PlanataInfo> mergeWithMatlis(List<PlanataInfo> baseInfos, List<MatlisInfo> selectedInfos) {
		InfoMergerBuilderV3<PlanataInfo, MatlisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PlanataVisiMergeMatlis());
		InfoMergerV3<PlanataInfo, MatlisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PlanataInfo> mergeToSelect(List<PlanataInfo> baseInfos, List<PlanataInfo> selectedInfos) {
		InfoMergerBuilderV3<PlanataInfo, PlanataInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PlanataVisiMergeToSelect());
		InfoMergerV3<PlanataInfo, PlanataInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
