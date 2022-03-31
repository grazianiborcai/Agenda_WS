package br.com.mind5.business.scheduleWeekData.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class SchedeekdatMerger {
	public static List<SchedeekdatInfo> mergeToSelect(List<SchedeekdatInfo> baseInfos, List<SchedeekdatInfo> selectedInfos) {
		InfoMergerBuilder<SchedeekdatInfo, SchedeekdatInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedeekdatMergerVisiToSelect());
		InfoMerger<SchedeekdatInfo, SchedeekdatInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
