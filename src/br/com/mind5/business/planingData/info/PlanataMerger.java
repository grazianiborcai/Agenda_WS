package br.com.mind5.business.planingData.info;

import java.util.List;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.info.temp.InfoMergerBuilder;
import br.com.mind5.info.temp.InfoMergerV3;

public final class PlanataMerger {		
	public static List<PlanataInfo> mergeWithMatlis(List<PlanataInfo> baseInfos, List<MatlisInfo> selectedInfos) {
		InfoMergerBuilder<PlanataInfo, MatlisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PlanataVisiMergeMatlis());
		InfoMergerV3<PlanataInfo, MatlisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PlanataInfo> mergeToSelect(List<PlanataInfo> baseInfos, List<PlanataInfo> selectedInfos) {
		InfoMergerBuilder<PlanataInfo, PlanataInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PlanataVisiMergeToSelect());
		InfoMergerV3<PlanataInfo, PlanataInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
