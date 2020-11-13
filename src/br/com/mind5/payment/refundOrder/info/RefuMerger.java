package br.com.mind5.payment.refundOrder.info;

import java.util.List;

import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.payment.payOrderItemSearch.info.PayormarchInfo;

public final class RefuMerger {
	public static List<RefuInfo> mergeWithPayormarch(List<RefuInfo> baseInfos, List<PayormarchInfo> selectedInfos) {
		InfoMergerBuilder<RefuInfo, PayormarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new RefuVisiMergePayormarch());
		InfoMerger<RefuInfo, PayormarchInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<RefuInfo> mergeWithOrdist(List<RefuInfo> baseInfos, List<OrdistInfo> selectedInfos) {
		InfoMergerBuilder<RefuInfo, OrdistInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new RefuVisiMergeOrdist());
		InfoMerger<RefuInfo, OrdistInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
