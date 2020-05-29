package br.com.mind5.business.scheduleYearData.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class SchedyeratMerger {
	public static List<SchedyeratInfo> mergeToSelect(List<SchedyeratInfo> baseInfos, List<SchedyeratInfo> selectedInfos) {
		InfoMergerBuilderV3<SchedyeratInfo, SchedyeratInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedyeratVisiMergeToSelect());
		InfoMergerV3<SchedyeratInfo, SchedyeratInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
