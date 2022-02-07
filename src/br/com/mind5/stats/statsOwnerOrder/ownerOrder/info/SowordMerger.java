package br.com.mind5.stats.statsOwnerOrder.ownerOrder.info;

import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderLive.info.SowordiveInfo;

public final class SowordMerger {
	public static List<SowordInfo> mergeWithSowordive(List<SowordInfo> baseInfos, List<SowordiveInfo> selectedInfos) {
		InfoMergerBuilder<SowordInfo, SowordiveInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowordVisiMergeSowordive());
		InfoMerger<SowordInfo, SowordiveInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SowordInfo> mergeWithCalonth(List<SowordInfo> baseInfos, List<CalonthInfo> selectedInfos) {
		InfoMergerBuilder<SowordInfo, CalonthInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowordVisiMergeCalonth());
		InfoMerger<SowordInfo, CalonthInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
