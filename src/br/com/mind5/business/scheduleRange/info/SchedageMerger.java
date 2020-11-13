package br.com.mind5.business.scheduleRange.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class SchedageMerger {
	public static List<SchedageInfo> mergeToSelect(List<SchedageInfo> baseInfos, List<SchedageInfo> selectedInfos) {
		InfoMergerBuilder<SchedageInfo, SchedageInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedageVisiMergeToSelect());
		InfoMerger<SchedageInfo, SchedageInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
