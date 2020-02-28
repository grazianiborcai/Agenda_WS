package br.com.mind5.payment.refundOrder.info;

import java.util.List;

import br.com.mind5.business.orderItemSearch.info.OrdemarchInfo;
import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class RefuMerger {
	public static List<RefuInfo> mergeWithOrdemarch(List<RefuInfo> baseInfos, List<OrdemarchInfo> selectedInfos) {
		InfoMergerBuilderV3<RefuInfo, OrdemarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new RefuVisiMergeOrdemarch());
		InfoMergerV3<RefuInfo, OrdemarchInfo> merger = builder.build();		
	
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
