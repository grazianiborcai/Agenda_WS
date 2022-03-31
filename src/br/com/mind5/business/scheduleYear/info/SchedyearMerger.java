package br.com.mind5.business.scheduleYear.info;

import java.util.List;

import br.com.mind5.business.scheduleYearData.info.SchedyeratInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.masterData.monthSearch.info.MontharchInfo;

public final class SchedyearMerger {
	public static List<SchedyearInfo> mergeWithStolis(List<SchedyearInfo> baseInfos, List<StolisInfo> selectedInfos) {
		InfoMergerBuilder<SchedyearInfo, StolisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedyearMergerVisiStolis());
		InfoMerger<SchedyearInfo, StolisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedyearInfo> mergeWithMontharch(List<SchedyearInfo> baseInfos, List<MontharchInfo> selectedInfos) {
		InfoMergerBuilder<SchedyearInfo, MontharchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedyearMergerVisiMontharch());
		InfoMerger<SchedyearInfo, MontharchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedyearInfo> mergeWithSchedyerat(List<SchedyearInfo> baseInfos, List<SchedyeratInfo> selectedInfos) {
		InfoMergerBuilder<SchedyearInfo, SchedyeratInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedyearMergerVisiSchedyerat());
		InfoMerger<SchedyearInfo, SchedyeratInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
