package br.com.mind5.business.storeProspect.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class StoprosMerger {	
	
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
