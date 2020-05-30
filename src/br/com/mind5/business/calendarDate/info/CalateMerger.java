package br.com.mind5.business.calendarDate.info;

import java.util.List;

import br.com.mind5.business.moonCalendar.info.MooncalInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.masterData.month.info.MonthInfo;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;

public final class CalateMerger {
	public static List<CalateInfo> mergeWithMonth(List<CalateInfo> baseInfos, List<MonthInfo> selectedInfos) {
		InfoMergerBuilderV3<CalateInfo, MonthInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CalateVisiMergeMonth());
		InfoMergerV3<CalateInfo, MonthInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CalateInfo> mergeWithMooncal(List<CalateInfo> baseInfos, List<MooncalInfo> selectedInfos) {
		InfoMergerBuilderV3<CalateInfo, MooncalInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CalateVisiMergeMooncal());
		InfoMergerV3<CalateInfo, MooncalInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CalateInfo> mergeWithWeekday(List<CalateInfo> baseInfos, List<WeekdayInfo> selectedInfos) {
		InfoMergerBuilderV3<CalateInfo, WeekdayInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CalateVisiMergeWeekday());
		InfoMergerV3<CalateInfo, WeekdayInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CalateInfo> mergeToSelect(List<CalateInfo> baseInfos, List<CalateInfo> selectedInfos) {
		InfoMergerBuilderV3<CalateInfo, CalateInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CalateVisiMergeToSelect());
		InfoMergerV3<CalateInfo, CalateInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
