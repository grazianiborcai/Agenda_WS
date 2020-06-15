package br.com.mind5.business.storeProspect.info;

import java.util.List;

import br.com.mind5.business.storeProspectSearch.info.StoprarchInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.masterData.prospectStatus.info.ProstusInfo;

public final class StoprosMerger {	
	public static List<StoprosInfo> mergeWithStoprarch(List<StoprosInfo> baseInfos, List<StoprarchInfo> selectedInfos) {
		InfoMergerBuilderV3<StoprosInfo, StoprarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoprosVisiMergeStoprarch());
		InfoMergerV3<StoprosInfo, StoprarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StoprosInfo> mergeWithProstus(List<StoprosInfo> baseInfos, List<ProstusInfo> selectedInfos) {
		InfoMergerBuilderV3<StoprosInfo, ProstusInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoprosVisiMergeProstus());
		InfoMergerV3<StoprosInfo, ProstusInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StoprosInfo> mergeToSelect(List<StoprosInfo> baseInfos, List<StoprosInfo> selectedInfos) {
		InfoMergerBuilderV3<StoprosInfo, StoprosInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoprosVisiMergeToSelect());
		InfoMergerV3<StoprosInfo, StoprosInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StoprosInfo> mergeToUpdate(List<StoprosInfo> baseInfos, List<StoprosInfo> selectedInfos) {
		InfoMergerBuilderV3<StoprosInfo, StoprosInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoprosVisiMergeToUpdate());
		InfoMergerV3<StoprosInfo, StoprosInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
