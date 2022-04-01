package br.com.mind5.business.calendarTimeEmployee.info;

import java.util.List;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.business.employeeLeaveDateRange.info.EmplargInfo;
import br.com.mind5.business.employeeWorkTimeSearch.info.EmpwotarchInfo;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class CalimempMerger {
	public static List<CalimempInfo> mergeWithEmplarg(List<CalimempInfo> baseInfos, List<EmplargInfo> selectedInfos) {
		InfoMergerBuilder<CalimempInfo, EmplargInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CalimempMergerVisiEmplarg());
		InfoMerger<CalimempInfo, EmplargInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CalimempInfo> mergeWithCalate(List<CalimempInfo> baseInfos, List<CalateInfo> selectedInfos) {
		InfoMergerBuilder<CalimempInfo, CalateInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CalimempMergerVisiCalate());
		InfoMerger<CalimempInfo, CalateInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CalimempInfo> mergeWithEmpwotarch(List<CalimempInfo> baseInfos, List<EmpwotarchInfo> selectedInfos) {
		InfoMergerBuilder<CalimempInfo, EmpwotarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CalimempMergerVisiEmpwotarch());
		InfoMerger<CalimempInfo, EmpwotarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
