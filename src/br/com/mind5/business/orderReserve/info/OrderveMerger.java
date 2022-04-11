package br.com.mind5.business.orderReserve.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class OrderveMerger {	
	public static List<OrderveInfo> mergeToSelect(List<OrderveInfo> baseInfos, List<OrderveInfo> selectedInfos) {
		InfoMergerBuilder<OrderveInfo, OrderveInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrderveMergerVisiToSelect());
		InfoMerger<OrderveInfo, OrderveInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
