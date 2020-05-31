package br.com.mind5.business.scheduleYear.info;

import java.util.List;

import br.com.mind5.business.scheduleYearData.info.SchedyeratInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.masterData.monthSearch.info.MontharchInfo;

public final class SchedyearMerger {
	public static List<SchedyearInfo> mergeWithStolis(List<SchedyearInfo> baseInfos, List<StolisInfo> selectedInfos) {
		InfoMergerBuilderV3<SchedyearInfo, StolisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedyearVisiMergeStolis());
		InfoMergerV3<SchedyearInfo, StolisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedyearInfo> mergeWithMontharch(List<SchedyearInfo> baseInfos, List<MontharchInfo> selectedInfos) {
		InfoMergerBuilderV3<SchedyearInfo, MontharchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedyearVisiMergeMontharch());
		InfoMergerV3<SchedyearInfo, MontharchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedyearInfo> mergeWithSchedyerat(List<SchedyearInfo> baseInfos, List<SchedyeratInfo> selectedInfos) {
		InfoMergerBuilderV3<SchedyearInfo, SchedyeratInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedyearVisiMergeSchedyerat());
		InfoMergerV3<SchedyearInfo, SchedyeratInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
