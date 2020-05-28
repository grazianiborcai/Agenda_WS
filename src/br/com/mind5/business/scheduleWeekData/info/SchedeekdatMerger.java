package br.com.mind5.business.scheduleWeekData.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class SchedeekdatMerger {
	public static List<SchedeekdatInfo> mergeToSelect(List<SchedeekdatInfo> baseInfos, List<SchedeekdatInfo> selectedInfos) {
		InfoMergerBuilderV3<SchedeekdatInfo, SchedeekdatInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedeekdatVisiMergeToSelect());
		InfoMergerV3<SchedeekdatInfo, SchedeekdatInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
