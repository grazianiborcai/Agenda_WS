package br.com.mind5.business.calendarWeekYear.info;

import java.util.List;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class CaleekyMerger {
	public static List<CaleekyInfo> mergeWithCalate(List<CaleekyInfo> baseInfos, List<CalateInfo> selectedInfos) {
		InfoMergerBuilder<CaleekyInfo, CalateInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CaleekyVisiMergeCalate());
		InfoMerger<CaleekyInfo, CalateInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CaleekyInfo> mergeToSelect(List<CaleekyInfo> baseInfos, List<CaleekyInfo> selectedInfos) {
		InfoMergerBuilder<CaleekyInfo, CaleekyInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CaleekyVisiMergeToSelect());
		InfoMerger<CaleekyInfo, CaleekyInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
