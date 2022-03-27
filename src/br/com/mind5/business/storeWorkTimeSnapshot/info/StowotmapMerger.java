package br.com.mind5.business.storeWorkTimeSnapshot.info;

import java.util.List;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;

public final class StowotmapMerger {
	public static List<StowotmapInfo> mergeWithWeekday(List<StowotmapInfo> baseInfos, List<WeekdayInfo> selectedInfos) {
		InfoMergerBuilder<StowotmapInfo, WeekdayInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StowotmapMergerVisiWeekday());
		InfoMerger<StowotmapInfo, WeekdayInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StowotmapInfo> mergeWithStolis(List<StowotmapInfo> baseInfos, List<StolisInfo> selectedInfos) {
		InfoMergerBuilder<StowotmapInfo, StolisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StowotmapMergerVisiStolis());
		InfoMerger<StowotmapInfo, StolisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	public static List<StowotmapInfo> mergeToSelect(List<StowotmapInfo> baseInfos, List<StowotmapInfo> selectedInfos) {
		InfoMergerBuilder<StowotmapInfo, StowotmapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StowotmapMergerVisiToSelect());
		InfoMerger<StowotmapInfo, StowotmapInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
