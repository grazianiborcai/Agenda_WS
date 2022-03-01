package br.com.mind5.stats.statsOwnerSale.ownerSale.info;

import java.util.List;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.stats.statsOwnerSale.ownerSaleAggr.info.SowalagrInfo;
import br.com.mind5.stats.statsOwnerSale.ownerSaleLive.info.SowaliveInfo;

public final class SowalMerger {
	public static List<SowalInfo> mergeWithSowalagr(List<SowalInfo> baseInfos, List<SowalagrInfo> selectedInfos) {
		InfoMergerBuilder<SowalInfo, SowalagrInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowalVisiMergeSowalagr());
		InfoMerger<SowalInfo, SowalagrInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SowalInfo> mergeWithSowalive(List<SowalInfo> baseInfos, List<SowaliveInfo> selectedInfos) {
		InfoMergerBuilder<SowalInfo, SowaliveInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowalVisiMergeSowalive());
		InfoMerger<SowalInfo, SowaliveInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SowalInfo> mergeWithStolis(List<SowalInfo> baseInfos, List<StolisInfo> selectedInfos) {
		InfoMergerBuilder<SowalInfo, StolisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowalVisiMergeStolis());
		InfoMerger<SowalInfo, StolisInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
