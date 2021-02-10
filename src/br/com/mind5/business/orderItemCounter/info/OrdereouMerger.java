package br.com.mind5.business.orderItemCounter.info;

import java.util.List;

import br.com.mind5.business.orderItemList.info.OrdemistInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;

public final class OrdereouMerger {	
	public static List<OrdereouInfo> mergeWithOrdemist(List<OrdereouInfo> baseInfos, List<OrdemistInfo> selectedInfos) {
		InfoMergerBuilder<OrdereouInfo, OrdemistInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdereouVisiMergeOrdemist());
		InfoMerger<OrdereouInfo, OrdemistInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
