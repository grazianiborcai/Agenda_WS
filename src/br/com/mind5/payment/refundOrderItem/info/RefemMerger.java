package br.com.mind5.payment.refundOrderItem.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.info.RefumoipInfo;

public final class RefemMerger {
	public static List<RefemInfo> mergeWithRefumoip(List<RefemInfo> baseInfos, List<RefumoipInfo> selectedInfos) {
		InfoMergerBuilderV3<RefemInfo, RefumoipInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new RefemVisiMergeRefumoip());
		InfoMergerV3<RefemInfo, RefumoipInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<RefemInfo> mergeWithPayord(List<RefemInfo> baseInfos, List<PayordInfo> selectedInfos) {
		InfoMergerBuilderV3<RefemInfo, PayordInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new RefemVisiMergePayord());
		InfoMergerV3<RefemInfo, PayordInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<RefemInfo> mergeWithCuspar(List<RefemInfo> baseInfos, List<CusparInfo> selectedInfos) {
		InfoMergerBuilderV3<RefemInfo, CusparInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new RefemVisiMergeCuspar());
		InfoMergerV3<RefemInfo, CusparInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
