package br.com.mind5.payment.statusPayOrderItem.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipInfo;

public final class PaytusemMerger {	
	public static List<PaytusemInfo> mergeWithPayordem(List<PaytusemInfo> baseInfos, List<PayordemInfo> selectedInfos) {
		InfoMergerBuilder<PaytusemInfo, PayordemInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PaytusemMergerVisiPayordem());
		InfoMerger<PaytusemInfo, PayordemInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<PaytusemInfo> mergeWithOrdmoip(List<PaytusemInfo> baseInfos, List<OrdmoipInfo> selectedInfos) {
		InfoMergerBuilder<PaytusemInfo, OrdmoipInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PaytusemMergerVisiOrdmoip());
		InfoMerger<PaytusemInfo, OrdmoipInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
