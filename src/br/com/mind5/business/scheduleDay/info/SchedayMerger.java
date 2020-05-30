package br.com.mind5.business.scheduleDay.info;

import java.util.List;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.scheduleDayData.info.SchedaytaInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.masterData.scheduleStatus.info.SchedatusInfo;

public final class SchedayMerger {
	public static List<SchedayInfo> mergeWithCalate(List<SchedayInfo> baseInfos, List<CalateInfo> selectedInfos) {
		InfoMergerBuilderV3<SchedayInfo, CalateInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedayVisiMergeCalate());
		InfoMergerV3<SchedayInfo, CalateInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedayInfo> mergeWithCuslis(List<SchedayInfo> baseInfos, List<CuslisInfo> selectedInfos) {
		InfoMergerBuilderV3<SchedayInfo, CuslisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedayVisiMergeCuslis());
		InfoMergerV3<SchedayInfo, CuslisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedayInfo> mergeWithSchedatus(List<SchedayInfo> baseInfos, List<SchedatusInfo> selectedInfos) {
		InfoMergerBuilderV3<SchedayInfo, SchedatusInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedayVisiMergeSchedatus());
		InfoMergerV3<SchedayInfo, SchedatusInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedayInfo> mergeWithEmplis(List<SchedayInfo> baseInfos, List<EmplisInfo> selectedInfos) {
		InfoMergerBuilderV3<SchedayInfo, EmplisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedayVisiMergeEmplis());
		InfoMergerV3<SchedayInfo, EmplisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedayInfo> mergeWithMatlis(List<SchedayInfo> baseInfos, List<MatlisInfo> selectedInfos) {
		InfoMergerBuilderV3<SchedayInfo, MatlisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedayVisiMergeMatlis());
		InfoMergerV3<SchedayInfo, MatlisInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<SchedayInfo> mergeWithStolis(List<SchedayInfo> baseInfos, List<StolisInfo> selectedInfos) {
		InfoMergerBuilderV3<SchedayInfo, StolisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedayVisiMergeStolis());
		InfoMergerV3<SchedayInfo, StolisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedayInfo> mergeWithSchedayta(List<SchedayInfo> baseInfos, List<SchedaytaInfo> selectedInfos) {
		InfoMergerBuilderV3<SchedayInfo, SchedaytaInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedayVisiMergeSchedayta());
		InfoMergerV3<SchedayInfo, SchedaytaInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
