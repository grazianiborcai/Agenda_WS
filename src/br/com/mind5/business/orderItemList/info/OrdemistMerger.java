package br.com.mind5.business.orderItemList.info;

import java.util.List;

import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;

public final class OrdemistMerger {
	public static List<OrdemistInfo> mergeWithOrdist(List<OrdemistInfo> baseInfos, List<OrdistInfo> selectedInfos) {
		InfoMergerBuilder<OrdemistInfo, OrdistInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdemistVisiMergeOrdist());
		InfoMerger<OrdemistInfo, OrdistInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<OrdemistInfo> mergeToSelect(List<OrdemistInfo> baseInfos, List<OrdemistInfo> selectedInfos) {
		InfoMergerBuilder<OrdemistInfo, OrdemistInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdemistVisiMergeToSelect());
		InfoMerger<OrdemistInfo, OrdemistInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
