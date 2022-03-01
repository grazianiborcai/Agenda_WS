package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonth.info;

import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthAggr.info.SowordagrInfo;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthLive.info.SowordiveInfo;

public final class SowordMerger {
	public static List<SowordInfo> mergeWithSowordive(List<SowordInfo> baseInfos, List<SowordiveInfo> selectedInfos) {
		InfoMergerBuilder<SowordInfo, SowordiveInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowordMergerVisiSowordive());
		InfoMerger<SowordInfo, SowordiveInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SowordInfo> mergeWithStolis(List<SowordInfo> baseInfos, List<StolisInfo> selectedInfos) {
		InfoMergerBuilder<SowordInfo, StolisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowordMergerVisiStolis());
		InfoMerger<SowordInfo, StolisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SowordInfo> mergeWithSowordagr(List<SowordInfo> baseInfos, List<SowordagrInfo> selectedInfos) {
		InfoMergerBuilder<SowordInfo, SowordagrInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowordMergerVisiSowordagr());
		InfoMerger<SowordInfo, SowordagrInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SowordInfo> mergeWithCalonth(List<SowordInfo> baseInfos, List<CalonthInfo> selectedInfos) {
		InfoMergerBuilder<SowordInfo, CalonthInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowordMergerVisiCalonth());
		InfoMerger<SowordInfo, CalonthInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
