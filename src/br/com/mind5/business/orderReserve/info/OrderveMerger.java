package br.com.mind5.business.orderReserve.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class OrderveMerger {	
	public static List<OrderveInfo> mergeToSelect(List<OrderveInfo> baseInfos, List<OrderveInfo> selectedInfos) {
		InfoMergerBuilderV3<OrderveInfo, OrderveInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrderveVisiMergeToSelect());
		InfoMergerV3<OrderveInfo, OrderveInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
