package br.com.mind5.business.calendarCatalogueData.info;

import java.util.List;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class CalguataMerger {
	public static List<CalguataInfo> mergeWithCalate(List<CalguataInfo> baseInfos, List<CalateInfo> selectedInfos) {
		InfoMergerBuilderV3<CalguataInfo, CalateInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CalguataVisiMergeCalate());
		InfoMergerV3<CalguataInfo, CalateInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
