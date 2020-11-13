package br.com.mind5.business.calendarCatalogueData.info;

import java.util.List;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class CalguataMerger {
	public static List<CalguataInfo> mergeWithCalate(List<CalguataInfo> baseInfos, List<CalateInfo> selectedInfos) {
		InfoMergerBuilder<CalguataInfo, CalateInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CalguataVisiMergeCalate());
		InfoMerger<CalguataInfo, CalateInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
