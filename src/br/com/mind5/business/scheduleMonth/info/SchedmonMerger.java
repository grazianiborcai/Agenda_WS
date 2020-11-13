package br.com.mind5.business.scheduleMonth.info;

import java.util.List;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.scheduleMonthData.info.SchedonthatInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class SchedmonMerger {
	public static List<SchedmonInfo> mergeWithEmplis(List<SchedmonInfo> baseInfos, List<EmplisInfo> selectedInfos) {
		InfoMergerBuilder<SchedmonInfo, EmplisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedmonVisiMergeEmplis());
		InfoMerger<SchedmonInfo, EmplisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedmonInfo> mergeWithCalate(List<SchedmonInfo> baseInfos, List<CalateInfo> selectedInfos) {
		InfoMergerBuilder<SchedmonInfo, CalateInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedmonVisiMergeCalate());
		InfoMerger<SchedmonInfo, CalateInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedmonInfo> mergeWithMatlis(List<SchedmonInfo> baseInfos, List<MatlisInfo> selectedInfos) {
		InfoMergerBuilder<SchedmonInfo, MatlisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedmonVisiMergeMatlis());
		InfoMerger<SchedmonInfo, MatlisInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<SchedmonInfo> mergeWithStolis(List<SchedmonInfo> baseInfos, List<StolisInfo> selectedInfos) {
		InfoMergerBuilder<SchedmonInfo, StolisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedmonVisiMergeStolis());
		InfoMerger<SchedmonInfo, StolisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedmonInfo> mergeWithSchedonthat(List<SchedmonInfo> baseInfos, List<SchedonthatInfo> selectedInfos) {
		InfoMergerBuilder<SchedmonInfo, SchedonthatInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedmonVisiMergeSchedonthat());
		InfoMerger<SchedmonInfo, SchedonthatInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
