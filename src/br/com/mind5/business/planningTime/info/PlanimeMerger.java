package br.com.mind5.business.planningTime.info;

import java.util.List;

import br.com.mind5.business.employeeRestricted.info.EmplresInfo;
import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.masterData.dayParting.info.DaypartInfo;
import br.com.mind5.masterData.moonPhase.info.MoonaseInfo;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;

public final class PlanimeMerger {
	public static List<PlanimeInfo> mergeWithMoonase(List<PlanimeInfo> baseInfos, List<MoonaseInfo> selectedInfos) {
		InfoMergerBuilder<PlanimeInfo, MoonaseInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PlanimeVisiMergeMoonase());
		InfoMerger<PlanimeInfo, MoonaseInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PlanimeInfo> mergeWithEmplres(List<PlanimeInfo> baseInfos, List<EmplresInfo> selectedInfos) {
		InfoMergerBuilder<PlanimeInfo, EmplresInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PlanimeVisiMergeEmplres());
		InfoMerger<PlanimeInfo, EmplresInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PlanimeInfo> mergeWithDaypart(List<PlanimeInfo> baseInfos, List<DaypartInfo> selectedInfos) {
		InfoMergerBuilder<PlanimeInfo, DaypartInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PlanimeVisiMergeDaypart());
		InfoMerger<PlanimeInfo, DaypartInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PlanimeInfo> mergeWithMatlis(List<PlanimeInfo> baseInfos, List<MatlisInfo> selectedInfos) {
		InfoMergerBuilder<PlanimeInfo, MatlisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PlanimeVisiMergeMatlis());
		InfoMerger<PlanimeInfo, MatlisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PlanimeInfo> mergeWithStolis(List<PlanimeInfo> baseInfos, List<StolisInfo> selectedInfos) {
		InfoMergerBuilder<PlanimeInfo, StolisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PlanimeVisiMergeStolis());
		InfoMerger<PlanimeInfo, StolisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PlanimeInfo> mergeWithWeekday(List<PlanimeInfo> baseInfos, List<WeekdayInfo> selectedInfos) {
		InfoMergerBuilder<PlanimeInfo, WeekdayInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PlanimeVisiMergeWeekday());
		InfoMerger<PlanimeInfo, WeekdayInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PlanimeInfo> mergeWithPlanata(List<PlanimeInfo> baseInfos, List<PlanataInfo> selectedInfos) {
		InfoMergerBuilder<PlanimeInfo, PlanataInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PlanimeVisiMergePlanata());
		InfoMerger<PlanimeInfo, PlanataInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
