package br.com.mind5.business.scheduleMonth.info;

import java.util.List;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.business.employeeRestricted.info.EmplresInfo;
import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.scheduleMonthData.info.SchedonthatInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;

public final class SchedmonMerger {
	public static List<SchedmonInfo> mergeWithEmplres(List<SchedmonInfo> baseInfos, List<EmplresInfo> selectedInfos) {
		InfoMergerBuilder<SchedmonInfo, EmplresInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedmonMergerVisiEmplres());
		InfoMerger<SchedmonInfo, EmplresInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedmonInfo> mergeWithCalate(List<SchedmonInfo> baseInfos, List<CalateInfo> selectedInfos) {
		InfoMergerBuilder<SchedmonInfo, CalateInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedmonMergerVisiCalate());
		InfoMerger<SchedmonInfo, CalateInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedmonInfo> mergeWithMatlis(List<SchedmonInfo> baseInfos, List<MatlisInfo> selectedInfos) {
		InfoMergerBuilder<SchedmonInfo, MatlisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedmonMergerVisiMatlis());
		InfoMerger<SchedmonInfo, MatlisInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<SchedmonInfo> mergeWithStolis(List<SchedmonInfo> baseInfos, List<StolisInfo> selectedInfos) {
		InfoMergerBuilder<SchedmonInfo, StolisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedmonMergerVisiStolis());
		InfoMerger<SchedmonInfo, StolisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedmonInfo> mergeWithSchedonthat(List<SchedmonInfo> baseInfos, List<SchedonthatInfo> selectedInfos) {
		InfoMergerBuilder<SchedmonInfo, SchedonthatInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedmonMergerVisiSchedonthat());
		InfoMerger<SchedmonInfo, SchedonthatInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
