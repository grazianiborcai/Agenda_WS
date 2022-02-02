package br.com.mind5.stats.statsStoreAccount.storeAccount.info;

import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.stats.statsStoreAccount.storeAccountLive.info.StoraciveInfo;

public final class StoracMerger {
	public static List<StoracInfo> mergeWithStoracive(List<StoracInfo> baseInfos, List<StoraciveInfo> selectedInfos) {
		InfoMergerBuilder<StoracInfo, StoraciveInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoracVisiMergeStoracive());
		InfoMerger<StoracInfo, StoraciveInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StoracInfo> mergeWithCalonth(List<StoracInfo> baseInfos, List<CalonthInfo> selectedInfos) {
		InfoMergerBuilder<StoracInfo, CalonthInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoracVisiMergeCalonth());
		InfoMerger<StoracInfo, CalonthInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
