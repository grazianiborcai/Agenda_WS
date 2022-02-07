package br.com.mind5.stats.statsOwnerUser.ownerUser.info;

import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.stats.statsOwnerUser.ownerUserLive.info.SowusiveInfo;

public final class SowusMerger {
	public static List<SowusInfo> mergeWithStoracive(List<SowusInfo> baseInfos, List<SowusiveInfo> selectedInfos) {
		InfoMergerBuilder<SowusInfo, SowusiveInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowusVisiMergeSuseracive());
		InfoMerger<SowusInfo, SowusiveInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SowusInfo> mergeWithCalonth(List<SowusInfo> baseInfos, List<CalonthInfo> selectedInfos) {
		InfoMergerBuilder<SowusInfo, CalonthInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowusVisiMergeCalonth());
		InfoMerger<SowusInfo, CalonthInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
