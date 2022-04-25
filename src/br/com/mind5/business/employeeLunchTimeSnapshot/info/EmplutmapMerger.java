package br.com.mind5.business.employeeLunchTimeSnapshot.info;

import java.util.List;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;

public final class EmplutmapMerger {
	public static List<EmplutmapInfo> mergeWithStolis(List<EmplutmapInfo> baseInfos, List<StolisInfo> selectedInfos) {
		InfoMergerBuilder<EmplutmapInfo, StolisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmplutmapMergerVisiStolis());
		InfoMerger<EmplutmapInfo, StolisInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<EmplutmapInfo> mergeWithWeekday(List<EmplutmapInfo> baseInfos, List<WeekdayInfo> selectedInfos) {
		InfoMergerBuilder<EmplutmapInfo, WeekdayInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmplutmapMergerVisiWeekday());
		InfoMerger<EmplutmapInfo, WeekdayInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmplutmapInfo> mergeToSelect(List<EmplutmapInfo> baseInfos, List<EmplutmapInfo> selectedInfos) {
		InfoMergerBuilder<EmplutmapInfo, EmplutmapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmplutmapMergerVisiToSelect());
		InfoMerger<EmplutmapInfo, EmplutmapInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
