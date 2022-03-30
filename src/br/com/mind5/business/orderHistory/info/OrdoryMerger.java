package br.com.mind5.business.orderHistory.info;

import java.util.List;

import br.com.mind5.business.orderItemList.info.OrdemistInfo;
import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;

public final class OrdoryMerger {	
	public static List<OrdoryInfo> mergeWithOrdist(List<OrdoryInfo> baseInfos, List<OrdistInfo> selectedInfos) {
		InfoMergerBuilder<OrdoryInfo, OrdistInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdoryMergerVisiOrdist());
		InfoMerger<OrdoryInfo, OrdistInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<OrdoryInfo> mergeWithOrdemist(List<OrdoryInfo> baseInfos, List<OrdemistInfo> selectedInfos) {
		InfoMergerBuilder<OrdoryInfo, OrdemistInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdoryMergerVisiOrdemist());
		InfoMerger<OrdoryInfo, OrdemistInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
