package br.com.mind5.business.scheduleDayData.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class SchedaytaMerger {	
	public static List<SchedaytaInfo> mergeToSelect(List<SchedaytaInfo> baseInfos, List<SchedaytaInfo> selectedInfos) {
		InfoMergerBuilderV3<SchedaytaInfo, SchedaytaInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedaytaVisiMergeToSelect());
		InfoMergerV3<SchedaytaInfo, SchedaytaInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
