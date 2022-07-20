package br.com.mind5.payment.payOrderItemList.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.payment.payOrderItemSearch.info.PayormarchInfo;

public final class PayordemistMerger {
	public static List<PayordemistInfo> mergeWithPayormarch(List<PayordemistInfo> baseInfos, List<PayormarchInfo> selectedInfos) {
		InfoMergerBuilder<PayordemistInfo, PayormarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PayordemistMergerVisiPayormarch());
		InfoMerger<PayordemistInfo, PayormarchInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<PayordemistInfo> mergeToSelect(List<PayordemistInfo> baseInfos, List<PayordemistInfo> selectedInfos) {
		InfoMergerBuilder<PayordemistInfo, PayordemistInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PayordemistMergerVisiToSelect());
		InfoMerger<PayordemistInfo, PayordemistInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
