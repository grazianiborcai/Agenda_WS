package br.com.mind5.payment.payOrder.info;

import java.util.List;

import br.com.mind5.business.masterData.info.PayparInfo;
import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info.MultmoipInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class PayordMerger {	
	public static List<PayordInfo> mergeWithMultmoip(List<PayordInfo> baseInfos, List<MultmoipInfo> selectedInfos) {
		InfoMergerBuilderV3<PayordInfo, MultmoipInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PayordVisiMergeMultmoip());
		InfoMergerV3<PayordInfo, MultmoipInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<PayordInfo> mergeWithPayordem(List<PayordInfo> baseInfos, List<PayordemInfo> selectedInfos) {
		InfoMergerBuilderV3<PayordInfo, PayordemInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PayordVisiMergePayordem());
		InfoMergerV3<PayordInfo, PayordemInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<PayordInfo> mergeWithCrecard(List<PayordInfo> baseInfos, List<CrecardInfo> selectedInfos) {
		InfoMergerBuilderV3<PayordInfo, CrecardInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PayordVisiMergeCrecard());
		InfoMergerV3<PayordInfo, CrecardInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<PayordInfo> mergeWithPaypar(List<PayordInfo> baseInfos, List<PayparInfo> selectedInfos) {
		InfoMergerBuilderV3<PayordInfo, PayparInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PayordVisiMergePaypar());
		InfoMergerV3<PayordInfo, PayparInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<PayordInfo> mergeWithOrder(List<PayordInfo> baseInfos, List<OrderInfo> selectedInfos) {
		InfoMergerBuilderV3<PayordInfo, OrderInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PayordVisiMergeOrder());
		InfoMergerV3<PayordInfo, OrderInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<PayordInfo> mergeWithUsername(List<PayordInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilderV3<PayordInfo, UsernameInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PayordVisiMergeUsername());
		InfoMergerV3<PayordInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<PayordInfo> mergeToSelect(List<PayordInfo> baseInfos, List<PayordInfo> selectedInfos) {
		InfoMergerBuilderV3<PayordInfo, PayordInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PayordVisiMergeToSelect());
		InfoMergerV3<PayordInfo, PayordInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<PayordInfo> mergeToUpdate(List<PayordInfo> baseInfos, List<PayordInfo> selectedInfos) {
		InfoMergerBuilderV3<PayordInfo, PayordInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PayordVisiMergeToUpdate());
		InfoMergerV3<PayordInfo, PayordInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
