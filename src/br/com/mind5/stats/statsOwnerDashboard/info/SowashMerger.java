package br.com.mind5.stats.statsOwnerDashboard.info;

import java.util.List;

import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.stats.statsOwnerOrder.ownerOrder.info.SowordInfo;
import br.com.mind5.stats.statsOwnerSchedule.ownerSchedule.info.SowedulInfo;
import br.com.mind5.stats.statsOwnerStore.ownerStore.info.SowotInfo;
import br.com.mind5.stats.statsOwnerUser.ownerUser.info.SowusInfo;

public final class SowashMerger {
	public static List<SowashInfo> mergeWithSowedul(List<SowashInfo> baseInfos, List<SowedulInfo> selectedInfos) {
		InfoMergerBuilder<SowashInfo, SowedulInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowashVisiMergeSowedul());
		InfoMerger<SowashInfo, SowedulInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SowashInfo> mergeWithSowot(List<SowashInfo> baseInfos, List<SowotInfo> selectedInfos) {
		InfoMergerBuilder<SowashInfo, SowotInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowashVisiMergeSowot());
		InfoMerger<SowashInfo, SowotInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SowashInfo> mergeWithSowus(List<SowashInfo> baseInfos, List<SowusInfo> selectedInfos) {
		InfoMergerBuilder<SowashInfo, SowusInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowashVisiMergeSowus());
		InfoMerger<SowashInfo, SowusInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SowashInfo> mergeWithSoword(List<SowashInfo> baseInfos, List<SowordInfo> selectedInfos) {
		InfoMergerBuilder<SowashInfo, SowordInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowashVisiMergeSoword());
		InfoMerger<SowashInfo, SowordInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
