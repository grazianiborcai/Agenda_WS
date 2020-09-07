package br.com.mind5.business.calendarDateAvailability.info;

import java.util.List;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class CalatityMerger {
	public static List<CalatityInfo> mergeWithCalate(List<CalatityInfo> baseInfos, List<CalateInfo> selectedInfos) {
		InfoMergerBuilderV3<CalatityInfo, CalateInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CalatityVisiMergeCalate());
		InfoMergerV3<CalatityInfo, CalateInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
