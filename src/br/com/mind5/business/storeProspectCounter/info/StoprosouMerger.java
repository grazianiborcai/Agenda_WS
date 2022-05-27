package br.com.mind5.business.storeProspectCounter.info;

import java.util.List;

import br.com.mind5.business.storeProspect.info.StoprosInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;

public final class StoprosouMerger {	
	public static List<StoprosouInfo> mergeWithStopros(List<StoprosouInfo> baseInfos, List<StoprosInfo> selectedInfos) {
		InfoMergerBuilder<StoprosouInfo, StoprosInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoprosouMergerVisiStopros());
		InfoMerger<StoprosouInfo, StoprosInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
