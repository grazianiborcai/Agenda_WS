package br.com.mind5.stats.statsOwnerStore.ownerStoreMonth.info;

import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthAggr.info.SowotagrInfo;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthLive.info.SowotiveInfo;

public final class SowotMerger {
	public static List<SowotInfo> mergeWithStolis(List<SowotInfo> baseInfos, List<StolisInfo> selectedInfos) {
		InfoMergerBuilder<SowotInfo, StolisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowotMergerVisiStolis());
		InfoMerger<SowotInfo, StolisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SowotInfo> mergeWithSowotive(List<SowotInfo> baseInfos, List<SowotiveInfo> selectedInfos) {
		InfoMergerBuilder<SowotInfo, SowotiveInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowotMergerVisiSowotive());
		InfoMerger<SowotInfo, SowotiveInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SowotInfo> mergeWithSowotagr(List<SowotInfo> baseInfos, List<SowotagrInfo> selectedInfos) {
		InfoMergerBuilder<SowotInfo, SowotagrInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowotMergerVisiSowotagr());
		InfoMerger<SowotInfo, SowotagrInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SowotInfo> mergeWithCalonth(List<SowotInfo> baseInfos, List<CalonthInfo> selectedInfos) {
		InfoMergerBuilder<SowotInfo, CalonthInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowotMergerVisiCalonth());
		InfoMerger<SowotInfo, CalonthInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
