package br.com.mind5.business.orderItemCounter.info;

import java.util.List;

import br.com.mind5.business.orderItemSearch.info.OrdemarchInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;

public final class OrdereouMerger {	
	public static List<OrdereouInfo> mergeWithOrdemarch(List<OrdereouInfo> baseInfos, List<OrdemarchInfo> selectedInfos) {
		InfoMergerBuilder<OrdereouInfo, OrdemarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdereouVisiMergeOrdemarch());
		InfoMerger<OrdereouInfo, OrdemarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
