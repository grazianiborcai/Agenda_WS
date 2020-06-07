package br.com.mind5.business.calendarTimeEmployee.info;

import java.util.List;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.business.employeeLeaveDateRange.info.EmplargInfo;
import br.com.mind5.business.employeeWorkTimeSearch.info.EmpwotarchInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class CalimempMerger {
	public static List<CalimempInfo> mergeWithEmplarg(List<CalimempInfo> baseInfos, List<EmplargInfo> selectedInfos) {
		InfoMergerBuilderV3<CalimempInfo, EmplargInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CalimempVisiMergeEmplarg());
		InfoMergerV3<CalimempInfo, EmplargInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CalimempInfo> mergeWithCalate(List<CalimempInfo> baseInfos, List<CalateInfo> selectedInfos) {
		InfoMergerBuilderV3<CalimempInfo, CalateInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CalimempVisiMergeCalate());
		InfoMergerV3<CalimempInfo, CalateInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CalimempInfo> mergeWithEmpwotarch(List<CalimempInfo> baseInfos, List<EmpwotarchInfo> selectedInfos) {
		InfoMergerBuilderV3<CalimempInfo, EmpwotarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CalimempVisiMergeEmpwotarch());
		InfoMergerV3<CalimempInfo, EmpwotarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
