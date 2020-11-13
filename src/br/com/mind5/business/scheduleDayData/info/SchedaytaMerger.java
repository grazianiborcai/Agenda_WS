package br.com.mind5.business.scheduleDayData.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class SchedaytaMerger {	
	public static List<SchedaytaInfo> mergeToSelect(List<SchedaytaInfo> baseInfos, List<SchedaytaInfo> selectedInfos) {
		InfoMergerBuilder<SchedaytaInfo, SchedaytaInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedaytaVisiMergeToSelect());
		InfoMerger<SchedaytaInfo, SchedaytaInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
