package br.com.mind5.business.calendarDateSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class CalatarchMerger {
	public static List<CalatarchInfo> mergeToSelect(List<CalatarchInfo> baseInfos, List<CalatarchInfo> selectedInfos) {
		InfoMergerBuilder<CalatarchInfo, CalatarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CalatarchVisiMergeToSelect());
		InfoMerger<CalatarchInfo, CalatarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
