package br.com.mind5.payment.payOrder.info;

import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.masterData.paymentPartner.info.PayparInfo;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info.MultmoipInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class PayordMerger {	
	public static List<PayordInfo> mergeWithMultmoip(List<PayordInfo> baseInfos, List<MultmoipInfo> selectedInfos) {
		InfoMergerBuilder<PayordInfo, MultmoipInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PayordMergerVisiMultmoip());
		InfoMerger<PayordInfo, MultmoipInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<PayordInfo> mergeWithPayordem(List<PayordInfo> baseInfos, List<PayordemInfo> selectedInfos) {
		InfoMergerBuilder<PayordInfo, PayordemInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PayordMergerVisiPayordem());
		InfoMerger<PayordInfo, PayordemInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<PayordInfo> mergeWithCrecard(List<PayordInfo> baseInfos, List<CrecardInfo> selectedInfos) {
		InfoMergerBuilder<PayordInfo, CrecardInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PayordMergerVisiCrecard());
		InfoMerger<PayordInfo, CrecardInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<PayordInfo> mergeWithPaypar(List<PayordInfo> baseInfos, List<PayparInfo> selectedInfos) {
		InfoMergerBuilder<PayordInfo, PayparInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PayordMergerVisiPaypar());
		InfoMerger<PayordInfo, PayparInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<PayordInfo> mergeWithOrder(List<PayordInfo> baseInfos, List<OrderInfo> selectedInfos) {
		InfoMergerBuilder<PayordInfo, OrderInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PayordMergerVisiOrder());
		InfoMerger<PayordInfo, OrderInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<PayordInfo> mergeWithUsername(List<PayordInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilder<PayordInfo, UsernameInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PayordMergerVisiUsername());
		InfoMerger<PayordInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<PayordInfo> mergeToSelect(List<PayordInfo> baseInfos, List<PayordInfo> selectedInfos) {
		InfoMergerBuilder<PayordInfo, PayordInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PayordMergerVisiToSelect());
		InfoMerger<PayordInfo, PayordInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<PayordInfo> mergeToUpdate(List<PayordInfo> baseInfos, List<PayordInfo> selectedInfos) {
		InfoMergerBuilder<PayordInfo, PayordInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PayordMergerVisiToUpdate());
		InfoMerger<PayordInfo, PayordInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
