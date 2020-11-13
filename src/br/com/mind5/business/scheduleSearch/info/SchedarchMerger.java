package br.com.mind5.business.scheduleSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class SchedarchMerger {
	public static List<SchedarchInfo> mergeToSelect(List<SchedarchInfo> baseInfos, List<SchedarchInfo> selectedInfos) {
		InfoMergerBuilder<SchedarchInfo, SchedarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedarchVisiMergeToSelect());
		InfoMerger<SchedarchInfo, SchedarchInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
