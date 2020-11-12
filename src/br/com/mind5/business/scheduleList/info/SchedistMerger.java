package br.com.mind5.business.scheduleList.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class SchedistMerger {
	public static List<SchedistInfo> mergeToSelect(List<SchedistInfo> baseInfos, List<SchedistInfo> selectedInfos) {
		InfoMergerBuilderV3<SchedistInfo, SchedistInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedistVisiMergeToSelect());
		InfoMergerV3<SchedistInfo, SchedistInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
