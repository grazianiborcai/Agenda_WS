package br.com.mind5.business.planningTime.info;

import java.util.List;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.masterData.info.WeekdayInfo;
import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.obsolete.InfoMerger_;

public final class PlanimeMerger {
	public static PlanimeInfo mergeWithEmplis(EmplisInfo selectedInfo, PlanimeInfo baseInfo) {
		InfoMerger_<PlanimeInfo, EmplisInfo> merger = new PlanimeMergerEmplis();		
		return merger.merge(selectedInfo, baseInfo);
	}
	
	
	
	public static List<PlanimeInfo> mergeWithEmplis(List<EmplisInfo> selectedInfos, List<PlanimeInfo> baseInfos) {
		InfoMerger_<PlanimeInfo, EmplisInfo> merger = new PlanimeMergerEmplis();		
		return merger.merge(selectedInfos, baseInfos);
	}
	
	
	
	public static PlanimeInfo mergeWithMatlis(MatlisInfo selectedInfo, PlanimeInfo baseInfo) {
		InfoMerger_<PlanimeInfo, MatlisInfo> merger = new PlanimeMergerMatlis();		
		return merger.merge(selectedInfo, baseInfo);
	}
	
	
	
	public static List<PlanimeInfo> mergeWithMatlis(List<MatlisInfo> selectedInfos, List<PlanimeInfo> baseInfos) {
		InfoMerger_<PlanimeInfo, MatlisInfo> merger = new PlanimeMergerMatlis();		
		return merger.merge(selectedInfos, baseInfos);
	}
	
	
	
	public static PlanimeInfo mergeWithStolis(StolisInfo selectedInfo, PlanimeInfo baseInfo) {
		InfoMerger_<PlanimeInfo, StolisInfo> merger = new PlanimeMergerStolis();		
		return merger.merge(selectedInfo, baseInfo);
	}
	
	
	
	public static List<PlanimeInfo> mergeWithStolis(List<StolisInfo> selectedInfos, List<PlanimeInfo> baseInfos) {
		InfoMerger_<PlanimeInfo, StolisInfo> merger = new PlanimeMergerStolis();		
		return merger.merge(selectedInfos, baseInfos);
	}
	
	
	
	public static PlanimeInfo mergeWithWeekday(WeekdayInfo selectedInfo, PlanimeInfo baseInfo) {
		InfoMerger_<PlanimeInfo, WeekdayInfo> merger = new PlanimeMergerWeekday();		
		return merger.merge(selectedInfo, baseInfo);
	}
	
	
	
	public static List<PlanimeInfo> mergeWithWeekday(List<WeekdayInfo> selectedInfos, List<PlanimeInfo> baseInfos) {
		InfoMerger_<PlanimeInfo, WeekdayInfo> merger = new PlanimeMergerWeekday();		
		return merger.merge(selectedInfos, baseInfos);
	}
	
	
	
	public static PlanimeInfo mergeWithPlanata(PlanataInfo selectedInfo, PlanimeInfo baseInfo) {
		InfoMerger_<PlanimeInfo, PlanataInfo> merger = new PlanimeMergerPlanata();		
		return merger.merge(selectedInfo, baseInfo);
	}
	
	
	
	public static List<PlanimeInfo> mergeWithPlanata(List<PlanataInfo> selectedInfos, List<PlanimeInfo> baseInfos) {
		InfoMerger_<PlanimeInfo, PlanataInfo> merger = new PlanimeMergerPlanata();		
		return merger.merge(selectedInfos, baseInfos);
	}
}
