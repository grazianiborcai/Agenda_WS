package br.com.mind5.business.calendarDateAvailability.info;

import java.util.List;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class CalatityMerger {
	public static List<CalatityInfo> mergeWithCalate(List<CalatityInfo> baseInfos, List<CalateInfo> selectedInfos) {
		InfoMergerBuilder<CalatityInfo, CalateInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CalatityVisiMergeCalate());
		InfoMerger<CalatityInfo, CalateInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
