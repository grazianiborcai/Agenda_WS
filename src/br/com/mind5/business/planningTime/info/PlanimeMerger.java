package br.com.mind5.business.planningTime.info;

import java.util.List;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.masterData.dayParting.info.DaypartInfo;
import br.com.mind5.masterData.moonPhase.info.MoonaseInfo;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;

public final class PlanimeMerger {
	public static List<PlanimeInfo> mergeWithMoonase(List<PlanimeInfo> baseInfos, List<MoonaseInfo> selectedInfos) {
		InfoMergerBuilderV3<PlanimeInfo, MoonaseInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PlanimeVisiMergeMoonase());
		InfoMergerV3<PlanimeInfo, MoonaseInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PlanimeInfo> mergeWithEmplis(List<PlanimeInfo> baseInfos, List<EmplisInfo> selectedInfos) {
		InfoMergerBuilderV3<PlanimeInfo, EmplisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PlanimeVisiMergeEmplis());
		InfoMergerV3<PlanimeInfo, EmplisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PlanimeInfo> mergeWithDaypart(List<PlanimeInfo> baseInfos, List<DaypartInfo> selectedInfos) {
		InfoMergerBuilderV3<PlanimeInfo, DaypartInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PlanimeVisiMergeDaypart());
		InfoMergerV3<PlanimeInfo, DaypartInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PlanimeInfo> mergeWithMatlis(List<PlanimeInfo> baseInfos, List<MatlisInfo> selectedInfos) {
		InfoMergerBuilderV3<PlanimeInfo, MatlisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PlanimeVisiMergeMatlis());
		InfoMergerV3<PlanimeInfo, MatlisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PlanimeInfo> mergeWithStolis(List<PlanimeInfo> baseInfos, List<StolisInfo> selectedInfos) {
		InfoMergerBuilderV3<PlanimeInfo, StolisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PlanimeVisiMergeStolis());
		InfoMergerV3<PlanimeInfo, StolisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PlanimeInfo> mergeWithWeekday(List<PlanimeInfo> baseInfos, List<WeekdayInfo> selectedInfos) {
		InfoMergerBuilderV3<PlanimeInfo, WeekdayInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PlanimeVisiMergeWeekday());
		InfoMergerV3<PlanimeInfo, WeekdayInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PlanimeInfo> mergeWithPlanata(List<PlanimeInfo> baseInfos, List<PlanataInfo> selectedInfos) {
		InfoMergerBuilderV3<PlanimeInfo, PlanataInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PlanimeVisiMergePlanata());
		InfoMergerV3<PlanimeInfo, PlanataInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
