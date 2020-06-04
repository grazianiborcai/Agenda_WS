package br.com.mind5.business.calendarWeekYear.info;

import java.util.List;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class CaleekyMerger {
	public static List<CaleekyInfo> mergeWithCalate(List<CaleekyInfo> baseInfos, List<CalateInfo> selectedInfos) {
		InfoMergerBuilderV3<CaleekyInfo, CalateInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CaleekyVisiMergeCalate());
		InfoMergerV3<CaleekyInfo, CalateInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CaleekyInfo> mergeToSelect(List<CaleekyInfo> baseInfos, List<CaleekyInfo> selectedInfos) {
		InfoMergerBuilderV3<CaleekyInfo, CaleekyInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CaleekyVisiMergeToSelect());
		InfoMergerV3<CaleekyInfo, CaleekyInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
