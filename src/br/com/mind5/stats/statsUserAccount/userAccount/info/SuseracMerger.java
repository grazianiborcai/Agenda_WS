package br.com.mind5.stats.statsUserAccount.userAccount.info;

import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.stats.statsUserAccount.userAccountLive.info.SuseraciveInfo;

public final class SuseracMerger {
	public static List<SuseracInfo> mergeWithStoracive(List<SuseracInfo> baseInfos, List<SuseraciveInfo> selectedInfos) {
		InfoMergerBuilder<SuseracInfo, SuseraciveInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SuseracVisiMergeSuseracive());
		InfoMerger<SuseracInfo, SuseraciveInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SuseracInfo> mergeWithCalonth(List<SuseracInfo> baseInfos, List<CalonthInfo> selectedInfos) {
		InfoMergerBuilder<SuseracInfo, CalonthInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SuseracVisiMergeCalonth());
		InfoMerger<SuseracInfo, CalonthInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
