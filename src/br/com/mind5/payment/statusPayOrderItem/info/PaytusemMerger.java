package br.com.mind5.payment.statusPayOrderItem.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipInfo;

public final class PaytusemMerger {	
	public static List<PaytusemInfo> mergeWithPayordem(List<PaytusemInfo> baseInfos, List<PayordemInfo> selectedInfos) {
		InfoMergerBuilderV3<PaytusemInfo, PayordemInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PaytusemVisiMergePayordem());
		InfoMergerV3<PaytusemInfo, PayordemInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<PaytusemInfo> mergeWithOrdmoip(List<PaytusemInfo> baseInfos, List<OrdmoipInfo> selectedInfos) {
		InfoMergerBuilderV3<PaytusemInfo, OrdmoipInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PaytusemVisiMergeOrdmoip());
		InfoMergerV3<PaytusemInfo, OrdmoipInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
