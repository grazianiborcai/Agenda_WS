package br.com.mind5.stats.statsStoreOrder.storeOrderDay.info;

import java.util.List;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayAggr.info.StordagrInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayLive.info.StordiveInfo;

public final class StordMerger {
	public static List<StordInfo> mergeWithStordagr(List<StordInfo> baseInfos, List<StordagrInfo> selectedInfos) {
		InfoMergerBuilder<StordInfo, StordagrInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StordVisiMergeStordagr());
		InfoMerger<StordInfo, StordagrInfo> merger = builder.build();
	
		return merger.merge();
	}
	
	
	
	public static List<StordInfo> mergeWithStolis(List<StordInfo> baseInfos, List<StolisInfo> selectedInfos) {
		InfoMergerBuilder<StordInfo, StolisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StordVisiMergeStolis());
		InfoMerger<StordInfo, StolisInfo> merger = builder.build();
	
		return merger.merge();
	}
	
	
	
	public static List<StordInfo> mergeWithStordive(List<StordInfo> baseInfos, List<StordiveInfo> selectedInfos) {
		InfoMergerBuilder<StordInfo, StordiveInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StordVisiMergeStordive());
		InfoMerger<StordInfo, StordiveInfo> merger = builder.build();
	
		return merger.merge();
	}
	
	
	
	public static List<StordInfo> mergeWithCalate(List<StordInfo> baseInfos, List<CalateInfo> selectedInfos) {
		InfoMergerBuilder<StordInfo, CalateInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StordVisiMergeCalate());
		InfoMerger<StordInfo, CalateInfo> merger = builder.build();
	
		return merger.merge();
	}
}
