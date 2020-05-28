package br.com.mind5.business.scheduleMonthData.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class SchedonthatMerger {
	public static List<SchedonthatInfo> mergeToSelect(List<SchedonthatInfo> baseInfos, List<SchedonthatInfo> selectedInfos) {
		InfoMergerBuilderV3<SchedonthatInfo, SchedonthatInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedonthatVisiMergeToSelect());
		InfoMergerV3<SchedonthatInfo, SchedonthatInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
