package br.com.mind5.stats.statsStoreProfile.storeProfileMonth.info;

import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonthAggr.info.StefilonagrInfo;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonthLive.info.StefiloniveInfo;

public final class StefilonMerger {
	public static List<StefilonInfo> mergeWithCalonth(List<StefilonInfo> baseInfos, List<CalonthInfo> selectedInfos) {
		InfoMergerBuilder<StefilonInfo, CalonthInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StefilonMergerVisiCalonth());
		InfoMerger<StefilonInfo, CalonthInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StefilonInfo> mergeWithStedmonagr(List<StefilonInfo> baseInfos, List<StefilonagrInfo> selectedInfos) {
		InfoMergerBuilder<StefilonInfo, StefilonagrInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StefilonMergerVisiStefilonagr());
		InfoMerger<StefilonInfo, StefilonagrInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StefilonInfo> mergeWithStedmonive(List<StefilonInfo> baseInfos, List<StefiloniveInfo> selectedInfos) {
		InfoMergerBuilder<StefilonInfo, StefiloniveInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StefilonMergerVisiStefilonive());
		InfoMerger<StefilonInfo, StefiloniveInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
