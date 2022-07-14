package br.com.mind5.stats.statsStoreOrder.storeOrderMonth.info;

import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthAggr.info.StoronagrInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthLive.info.StoroniveInfo;

public final class StoronMerger {
	public static List<StoronInfo> mergeWithCalonth(List<StoronInfo> baseInfos, List<CalonthInfo> selectedInfos) {
		InfoMergerBuilder<StoronInfo, CalonthInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoronMergerVisiCalonth());
		InfoMerger<StoronInfo, CalonthInfo> merger = builder.build();
	
		return merger.merge();
	}
	
	
	
	public static List<StoronInfo> mergeWithStoronagr(List<StoronInfo> baseInfos, List<StoronagrInfo> selectedInfos) {
		InfoMergerBuilder<StoronInfo, StoronagrInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoronMergerVisiStoronagr());
		InfoMerger<StoronInfo, StoronagrInfo> merger = builder.build();
	
		return merger.merge();
	}
	
	
	
	public static List<StoronInfo> mergeWithStolis(List<StoronInfo> baseInfos, List<StolisInfo> selectedInfos) {
		InfoMergerBuilder<StoronInfo, StolisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoronMergerVisiStolis());
		InfoMerger<StoronInfo, StolisInfo> merger = builder.build();
	
		return merger.merge();
	}
	
	
	
	public static List<StoronInfo> mergeWithStoronive(List<StoronInfo> baseInfos, List<StoroniveInfo> selectedInfos) {
		InfoMergerBuilder<StoronInfo, StoroniveInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoronMergerVisiStoronive());
		InfoMerger<StoronInfo, StoroniveInfo> merger = builder.build();
	
		return merger.merge();
	}
}
