package br.com.mind5.payment.refundOrderItem.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;
import br.com.mind5.payment.payOrderItemSearch.info.PayormarchInfo;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.info.RefumoipInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class RefemMerger {
	public static List<RefemInfo> mergeWithUsername(List<RefemInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilder<RefemInfo, UsernameInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new RefemMergerVisiUsername());
		InfoMerger<RefemInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<RefemInfo> mergeWithPayormarch(List<RefemInfo> baseInfos, List<PayormarchInfo> selectedInfos) {
		InfoMergerBuilder<RefemInfo, PayormarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new RefemMergerVisiPayormarch());
		InfoMerger<RefemInfo, PayormarchInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<RefemInfo> mergeWithRefumoip(List<RefemInfo> baseInfos, List<RefumoipInfo> selectedInfos) {
		InfoMergerBuilder<RefemInfo, RefumoipInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new RefemMergerVisiRefumoip());
		InfoMerger<RefemInfo, RefumoipInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<RefemInfo> mergeWithPayord(List<RefemInfo> baseInfos, List<PayordInfo> selectedInfos) {
		InfoMergerBuilder<RefemInfo, PayordInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new RefemMergerVisiPayord());
		InfoMerger<RefemInfo, PayordInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<RefemInfo> mergeWithPayordem(List<RefemInfo> baseInfos, List<PayordemInfo> selectedInfos) {
		InfoMergerBuilder<RefemInfo, PayordemInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new RefemMergerVisiPayordem());
		InfoMerger<RefemInfo, PayordemInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<RefemInfo> mergeWithCuspar(List<RefemInfo> baseInfos, List<CusparInfo> selectedInfos) {
		InfoMergerBuilder<RefemInfo, CusparInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new RefemMergerVisiCuspar());
		InfoMerger<RefemInfo, CusparInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
