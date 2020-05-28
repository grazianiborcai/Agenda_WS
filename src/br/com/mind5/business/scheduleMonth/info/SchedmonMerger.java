package br.com.mind5.business.scheduleMonth.info;

import java.util.List;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.moonCalendar.info.MooncalInfo;
import br.com.mind5.business.scheduleMonthData.info.SchedonthatInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.masterData.month.info.MonthInfo;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;

public final class SchedmonMerger {
	public static List<SchedmonInfo> mergeWithMooncal(List<SchedmonInfo> baseInfos, List<MooncalInfo> selectedInfos) {
		InfoMergerBuilderV3<SchedmonInfo, MooncalInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedmonVisiMergeMooncal());
		InfoMergerV3<SchedmonInfo, MooncalInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedmonInfo> mergeWithEmplis(List<SchedmonInfo> baseInfos, List<EmplisInfo> selectedInfos) {
		InfoMergerBuilderV3<SchedmonInfo, EmplisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedmonVisiMergeEmplis());
		InfoMergerV3<SchedmonInfo, EmplisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedmonInfo> mergeWithWeekday(List<SchedmonInfo> baseInfos, List<WeekdayInfo> selectedInfos) {
		InfoMergerBuilderV3<SchedmonInfo, WeekdayInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedmonVisiMergeWeekday());
		InfoMergerV3<SchedmonInfo, WeekdayInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedmonInfo> mergeWithMonth(List<SchedmonInfo> baseInfos, List<MonthInfo> selectedInfos) {
		InfoMergerBuilderV3<SchedmonInfo, MonthInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedmonVisiMergeMonth());
		InfoMergerV3<SchedmonInfo, MonthInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedmonInfo> mergeWithMatlis(List<SchedmonInfo> baseInfos, List<MatlisInfo> selectedInfos) {
		InfoMergerBuilderV3<SchedmonInfo, MatlisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedmonVisiMergeMatlis());
		InfoMergerV3<SchedmonInfo, MatlisInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<SchedmonInfo> mergeWithStolis(List<SchedmonInfo> baseInfos, List<StolisInfo> selectedInfos) {
		InfoMergerBuilderV3<SchedmonInfo, StolisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedmonVisiMergeStolis());
		InfoMergerV3<SchedmonInfo, StolisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedmonInfo> mergeWithSchedonthat(List<SchedmonInfo> baseInfos, List<SchedonthatInfo> selectedInfos) {
		InfoMergerBuilderV3<SchedmonInfo, SchedonthatInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedmonVisiMergeSchedonthat());
		InfoMergerV3<SchedmonInfo, SchedonthatInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
