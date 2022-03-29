package br.com.mind5.business.scheduleList.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class SchedistMerger {
	public static List<SchedistInfo> mergeToSelect(List<SchedistInfo> baseInfos, List<SchedistInfo> selectedInfos) {
		InfoMergerBuilder<SchedistInfo, SchedistInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedistMergerVisiToSelect());
		InfoMerger<SchedistInfo, SchedistInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
