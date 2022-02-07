package br.com.mind5.stats.statsOwnerStore.ownerStore.info;

import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.stats.statsOwnerStore.storeAccountLive.info.StoraciveInfo;

public final class SowotMerger {
	public static List<SowotInfo> mergeWithStoracive(List<SowotInfo> baseInfos, List<StoraciveInfo> selectedInfos) {
		InfoMergerBuilder<SowotInfo, StoraciveInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowotVisiMergeStoracive());
		InfoMerger<SowotInfo, StoraciveInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SowotInfo> mergeWithCalonth(List<SowotInfo> baseInfos, List<CalonthInfo> selectedInfos) {
		InfoMergerBuilder<SowotInfo, CalonthInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowotVisiMergeCalonth());
		InfoMerger<SowotInfo, CalonthInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
