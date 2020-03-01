package br.com.mind5.payment.refundOrder.info;

import java.util.List;

import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.payment.payOrderItemSearch.info.PayormarchInfo;

public final class RefuMerger {
	public static List<RefuInfo> mergeWithPayormarch(List<RefuInfo> baseInfos, List<PayormarchInfo> selectedInfos) {
		InfoMergerBuilderV3<RefuInfo, PayormarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new RefuVisiMergePayormarch());
		InfoMergerV3<RefuInfo, PayormarchInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<RefuInfo> mergeWithOrdist(List<RefuInfo> baseInfos, List<OrdistInfo> selectedInfos) {
		InfoMergerBuilderV3<RefuInfo, OrdistInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new RefuVisiMergeOrdist());
		InfoMergerV3<RefuInfo, OrdistInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
