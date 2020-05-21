package br.com.mind5.business.scheduleMonthData.info;

import java.util.List;

import br.com.mind5.business.masterData.info.MonthInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;

public final class SchedonthatMerger {
	public static List<SchedonthatInfo> mergeWithWeekday(List<SchedonthatInfo> baseInfos, List<WeekdayInfo> selectedInfos) {
		InfoMergerBuilderV3<SchedonthatInfo, WeekdayInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedonthatVisiMergeWeekday());
		InfoMergerV3<SchedonthatInfo, WeekdayInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedonthatInfo> mergeWithMonth(List<SchedonthatInfo> baseInfos, List<MonthInfo> selectedInfos) {
		InfoMergerBuilderV3<SchedonthatInfo, MonthInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedonthatVisiMergeMonth());
		InfoMergerV3<SchedonthatInfo, MonthInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedonthatInfo> mergeToSelect(List<SchedonthatInfo> baseInfos, List<SchedonthatInfo> selectedInfos) {
		InfoMergerBuilderV3<SchedonthatInfo, SchedonthatInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedonthatVisiMergeToSelect());
		InfoMergerV3<SchedonthatInfo, SchedonthatInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
