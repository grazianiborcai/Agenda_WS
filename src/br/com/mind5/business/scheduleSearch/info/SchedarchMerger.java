package br.com.mind5.business.scheduleSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class SchedarchMerger {
	public static List<SchedarchInfo> mergeToSelect(List<SchedarchInfo> baseInfos, List<SchedarchInfo> selectedInfos) {
		InfoMergerBuilderV3<SchedarchInfo, SchedarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedarchVisiMergeToSelect());
		InfoMergerV3<SchedarchInfo, SchedarchInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
