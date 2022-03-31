package br.com.mind5.business.scheduleYearData.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class SchedyeratMerger {
	public static List<SchedyeratInfo> mergeToSelect(List<SchedyeratInfo> baseInfos, List<SchedyeratInfo> selectedInfos) {
		InfoMergerBuilder<SchedyeratInfo, SchedyeratInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedyeratMergerVisiToSelect());
		InfoMerger<SchedyeratInfo, SchedyeratInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
