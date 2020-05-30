package br.com.mind5.business.calendarDateSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class CalatarchMerger {
	public static List<CalatarchInfo> mergeToSelect(List<CalatarchInfo> baseInfos, List<CalatarchInfo> selectedInfos) {
		InfoMergerBuilderV3<CalatarchInfo, CalatarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CalatarchVisiMergeToSelect());
		InfoMergerV3<CalatarchInfo, CalatarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
