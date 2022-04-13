package br.com.mind5.business.storeLunchTimeSnapshot.info;

import java.util.List;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;

public final class StuntmapMerger {
	public static List<StuntmapInfo> mergeWithWeekday(List<StuntmapInfo> baseInfos, List<WeekdayInfo> selectedInfos) {
		InfoMergerBuilder<StuntmapInfo, WeekdayInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StuntmapMergerVisiWeekday());
		InfoMerger<StuntmapInfo, WeekdayInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StuntmapInfo> mergeWithStolis(List<StuntmapInfo> baseInfos, List<StolisInfo> selectedInfos) {
		InfoMergerBuilder<StuntmapInfo, StolisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StuntmapMergerVisiStolis());
		InfoMerger<StuntmapInfo, StolisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	public static List<StuntmapInfo> mergeToSelect(List<StuntmapInfo> baseInfos, List<StuntmapInfo> selectedInfos) {
		InfoMergerBuilder<StuntmapInfo, StuntmapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StuntmapMergerVisiToSelect());
		InfoMerger<StuntmapInfo, StuntmapInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
