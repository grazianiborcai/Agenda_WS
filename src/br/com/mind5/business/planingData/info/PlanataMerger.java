package br.com.mind5.business.planingData.info;

import java.util.List;

import br.com.mind5.business.calendarMoon.info.MooncalInfo;
import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class PlanataMerger {		
	public static List<PlanataInfo> mergeWithMooncal(List<PlanataInfo> baseInfos, List<MooncalInfo> selectedInfos) {
		InfoMergerBuilder<PlanataInfo, MooncalInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PlanataVisiMergeMooncal());
		InfoMerger<PlanataInfo, MooncalInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PlanataInfo> mergeWithMatlis(List<PlanataInfo> baseInfos, List<MatlisInfo> selectedInfos) {
		InfoMergerBuilder<PlanataInfo, MatlisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PlanataVisiMergeMatlis());
		InfoMerger<PlanataInfo, MatlisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PlanataInfo> mergeToSelect(List<PlanataInfo> baseInfos, List<PlanataInfo> selectedInfos) {
		InfoMergerBuilder<PlanataInfo, PlanataInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PlanataVisiMergeToSelect());
		InfoMerger<PlanataInfo, PlanataInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
