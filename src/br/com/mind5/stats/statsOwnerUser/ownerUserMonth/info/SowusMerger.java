package br.com.mind5.stats.statsOwnerUser.ownerUserMonth.info;

import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.masterData.stateSearch.info.StatarchInfo;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthAggr.info.SowusagrInfo;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthLive.info.SowusiveInfo;

public final class SowusMerger {
	public static List<SowusInfo> mergeWithStolis(List<SowusInfo> baseInfos, List<StolisInfo> selectedInfos) {
		InfoMergerBuilder<SowusInfo, StolisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowusMergerVisiStolis());
		InfoMerger<SowusInfo, StolisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SowusInfo> mergeWithStatarch(List<SowusInfo> baseInfos, List<StatarchInfo> selectedInfos) {
		InfoMergerBuilder<SowusInfo, StatarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowusMergerVisiStatarch());
		InfoMerger<SowusInfo, StatarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SowusInfo> mergeWithSowusive(List<SowusInfo> baseInfos, List<SowusiveInfo> selectedInfos) {
		InfoMergerBuilder<SowusInfo, SowusiveInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowusMergerVisiSowusive());
		InfoMerger<SowusInfo, SowusiveInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SowusInfo> mergeWithSowusagr(List<SowusInfo> baseInfos, List<SowusagrInfo> selectedInfos) {
		InfoMergerBuilder<SowusInfo, SowusagrInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowusMergerVisiSowusagr());
		InfoMerger<SowusInfo, SowusagrInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SowusInfo> mergeWithCalonth(List<SowusInfo> baseInfos, List<CalonthInfo> selectedInfos) {
		InfoMergerBuilder<SowusInfo, CalonthInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowusMergerVisiCalonth());
		InfoMerger<SowusInfo, CalonthInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
