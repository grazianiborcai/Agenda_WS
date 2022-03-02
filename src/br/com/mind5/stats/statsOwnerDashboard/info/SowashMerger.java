package br.com.mind5.stats.statsOwnerDashboard.info;

import java.util.List;

import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonth.info.SowordInfo;
import br.com.mind5.stats.statsOwnerSale.ownerSale.info.SowalInfo;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonth.info.SowedulInfo;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonth.info.SowotInfo;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonth.info.SowusInfo;

public final class SowashMerger {
	public static List<SowashInfo> mergeWithSowedul(List<SowashInfo> baseInfos, List<SowedulInfo> selectedInfos) {
		InfoMergerBuilder<SowashInfo, SowedulInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowashMergerVisiSowedul());
		InfoMerger<SowashInfo, SowedulInfo> merger = builder.build();
	
		return merger.merge();
	}
	
	
	
	public static List<SowashInfo> mergeWithSowal(List<SowashInfo> baseInfos, List<SowalInfo> selectedInfos) {
		InfoMergerBuilder<SowashInfo, SowalInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowashMergerVisiSowal());
		InfoMerger<SowashInfo, SowalInfo> merger = builder.build();
	
		return merger.merge();
	}
	
	
	
	public static List<SowashInfo> mergeWithSowot(List<SowashInfo> baseInfos, List<SowotInfo> selectedInfos) {
		InfoMergerBuilder<SowashInfo, SowotInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowashMergerVisiSowot());
		InfoMerger<SowashInfo, SowotInfo> merger = builder.build();
	
		return merger.merge();
	}
	
	
	
	public static List<SowashInfo> mergeWithSowus(List<SowashInfo> baseInfos, List<SowusInfo> selectedInfos) {
		InfoMergerBuilder<SowashInfo, SowusInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowashMergerVisiSowus());
		InfoMerger<SowashInfo, SowusInfo> merger = builder.build();
	
		return merger.merge();
	}
	
	
	
	public static List<SowashInfo> mergeWithSoword(List<SowashInfo> baseInfos, List<SowordInfo> selectedInfos) {
		InfoMergerBuilder<SowashInfo, SowordInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowashMergerVisiSoword());
		InfoMerger<SowashInfo, SowordInfo> merger = builder.build();
	
		return merger.merge();
	}
}
