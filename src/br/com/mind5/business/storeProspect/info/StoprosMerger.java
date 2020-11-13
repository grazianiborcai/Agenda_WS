package br.com.mind5.business.storeProspect.info;

import java.util.List;

import br.com.mind5.business.storeProspectSearch.info.StoprarchInfo;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.masterData.prospectStatus.info.ProstusInfo;

public final class StoprosMerger {	
	public static List<StoprosInfo> mergeWithStoprarch(List<StoprosInfo> baseInfos, List<StoprarchInfo> selectedInfos) {
		InfoMergerBuilder<StoprosInfo, StoprarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoprosVisiMergeStoprarch());
		InfoMerger<StoprosInfo, StoprarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StoprosInfo> mergeWithProstus(List<StoprosInfo> baseInfos, List<ProstusInfo> selectedInfos) {
		InfoMergerBuilder<StoprosInfo, ProstusInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoprosVisiMergeProstus());
		InfoMerger<StoprosInfo, ProstusInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StoprosInfo> mergeToSelect(List<StoprosInfo> baseInfos, List<StoprosInfo> selectedInfos) {
		InfoMergerBuilder<StoprosInfo, StoprosInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoprosVisiMergeToSelect());
		InfoMerger<StoprosInfo, StoprosInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StoprosInfo> mergeToUpdate(List<StoprosInfo> baseInfos, List<StoprosInfo> selectedInfos) {
		InfoMergerBuilder<StoprosInfo, StoprosInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoprosVisiMergeToUpdate());
		InfoMerger<StoprosInfo, StoprosInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
