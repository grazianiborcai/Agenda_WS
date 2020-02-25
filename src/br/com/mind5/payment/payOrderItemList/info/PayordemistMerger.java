package br.com.mind5.payment.payOrderItemList.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.payment.payOrderItemSearch.info.PayormarchInfo;

public final class PayordemistMerger {
	public static List<PayordemistInfo> mergeWithPayormarch(List<PayordemistInfo> baseInfos, List<PayormarchInfo> selectedInfos) {
		InfoMergerBuilderV3<PayordemistInfo, PayormarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PayordemistVisiMergePayormarch());
		InfoMergerV3<PayordemistInfo, PayormarchInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<PayordemistInfo> mergeToSelect(List<PayordemistInfo> baseInfos, List<PayordemistInfo> selectedInfos) {
		InfoMergerBuilderV3<PayordemistInfo, PayordemistInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PayordemistVisiMergeToSelect());
		InfoMergerV3<PayordemistInfo, PayordemistInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
