package br.com.mind5.business.scheduleDay.info;

import java.util.List;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.business.calendarTimeStore.info.CalimoreInfo;
import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.business.employeeRestricted.info.EmplresInfo;
import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.scheduleDayData.info.SchedaytaInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.masterData.scheduleStatus.info.SchedatusInfo;

public final class SchedayMerger {
	public static List<SchedayInfo> mergeWithCalimore(List<SchedayInfo> baseInfos, List<CalimoreInfo> selectedInfos) {
		InfoMergerBuilder<SchedayInfo, CalimoreInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedayVisiMergeCalimore());
		InfoMerger<SchedayInfo, CalimoreInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedayInfo> mergeWithCalate(List<SchedayInfo> baseInfos, List<CalateInfo> selectedInfos) {
		InfoMergerBuilder<SchedayInfo, CalateInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedayVisiMergeCalate());
		InfoMerger<SchedayInfo, CalateInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedayInfo> mergeWithDate(List<SchedayInfo> baseInfos, List<CalateInfo> selectedInfos) {
		InfoMergerBuilder<SchedayInfo, CalateInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedayVisiMergeDate());
		InfoMerger<SchedayInfo, CalateInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedayInfo> mergeWithCuslis(List<SchedayInfo> baseInfos, List<CuslisInfo> selectedInfos) {
		InfoMergerBuilder<SchedayInfo, CuslisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedayVisiMergeCuslis());
		InfoMerger<SchedayInfo, CuslisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedayInfo> mergeWithSchedatus(List<SchedayInfo> baseInfos, List<SchedatusInfo> selectedInfos) {
		InfoMergerBuilder<SchedayInfo, SchedatusInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedayVisiMergeSchedatus());
		InfoMerger<SchedayInfo, SchedatusInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedayInfo> mergeWithEmplres(List<SchedayInfo> baseInfos, List<EmplresInfo> selectedInfos) {
		InfoMergerBuilder<SchedayInfo, EmplresInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedayVisiMergeEmplres());
		InfoMerger<SchedayInfo, EmplresInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedayInfo> mergeWithMatlis(List<SchedayInfo> baseInfos, List<MatlisInfo> selectedInfos) {
		InfoMergerBuilder<SchedayInfo, MatlisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedayVisiMergeMatlis());
		InfoMerger<SchedayInfo, MatlisInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<SchedayInfo> mergeWithStolis(List<SchedayInfo> baseInfos, List<StolisInfo> selectedInfos) {
		InfoMergerBuilder<SchedayInfo, StolisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedayVisiMergeStolis());
		InfoMerger<SchedayInfo, StolisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedayInfo> mergeWithSchedayta(List<SchedayInfo> baseInfos, List<SchedaytaInfo> selectedInfos) {
		InfoMergerBuilder<SchedayInfo, SchedaytaInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedayVisiMergeSchedayta());
		InfoMerger<SchedayInfo, SchedaytaInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
