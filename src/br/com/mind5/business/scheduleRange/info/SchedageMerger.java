package br.com.mind5.business.scheduleRange.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class SchedageMerger {
	public static List<SchedageInfo> mergeToSelect(List<SchedageInfo> baseInfos, List<SchedageInfo> selectedInfos) {
		InfoMergerBuilderV3<SchedageInfo, SchedageInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedageVisiMergeToSelect());
		InfoMergerV3<SchedageInfo, SchedageInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
