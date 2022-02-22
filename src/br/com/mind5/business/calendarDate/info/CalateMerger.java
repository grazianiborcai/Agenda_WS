package br.com.mind5.business.calendarDate.info;

import java.util.List;

import br.com.mind5.business.calendarDateSearch.info.CalatarchInfo;
import br.com.mind5.business.calendarMoon.info.MooncalInfo;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.masterData.month.info.MonthInfo;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;

public final class CalateMerger {
	public static List<CalateInfo> mergeWithCalatarch(List<CalateInfo> baseInfos, List<CalatarchInfo> selectedInfos) {
		InfoMergerBuilder<CalateInfo, CalatarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CalateVisiMergeCalatarch());
		InfoMerger<CalateInfo, CalatarchInfo> merger = builder.build();
	
		return merger.merge();
	}
	
	
	
	public static List<CalateInfo> mergeWithMonth(List<CalateInfo> baseInfos, List<MonthInfo> selectedInfos) {
		InfoMergerBuilder<CalateInfo, MonthInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CalateVisiMergeMonth());
		InfoMerger<CalateInfo, MonthInfo> merger = builder.build();
	
		return merger.merge();
	}
	
	
	
	public static List<CalateInfo> mergeWithMooncal(List<CalateInfo> baseInfos, List<MooncalInfo> selectedInfos) {
		InfoMergerBuilder<CalateInfo, MooncalInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CalateVisiMergeMooncal());
		InfoMerger<CalateInfo, MooncalInfo> merger = builder.build();
	
		return merger.merge();
	}
	
	
	
	public static List<CalateInfo> mergeWithWeekday(List<CalateInfo> baseInfos, List<WeekdayInfo> selectedInfos) {
		InfoMergerBuilder<CalateInfo, WeekdayInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CalateVisiMergeWeekday());
		InfoMerger<CalateInfo, WeekdayInfo> merger = builder.build();
	
		return merger.merge();
	}
	
	
	
	public static List<CalateInfo> mergeToSelect(List<CalateInfo> baseInfos, List<CalateInfo> selectedInfos) {
		InfoMergerBuilder<CalateInfo, CalateInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CalateVisiMergeToSelect());
		InfoMerger<CalateInfo, CalateInfo> merger = builder.build();
	
		return merger.merge();
	}
}
