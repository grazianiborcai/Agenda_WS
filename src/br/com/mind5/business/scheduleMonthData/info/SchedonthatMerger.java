package br.com.mind5.business.scheduleMonthData.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class SchedonthatMerger {
	public static List<SchedonthatInfo> mergeToSelect(List<SchedonthatInfo> baseInfos, List<SchedonthatInfo> selectedInfos) {
		InfoMergerBuilder<SchedonthatInfo, SchedonthatInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedonthatVisiMergeToSelect());
		InfoMerger<SchedonthatInfo, SchedonthatInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
