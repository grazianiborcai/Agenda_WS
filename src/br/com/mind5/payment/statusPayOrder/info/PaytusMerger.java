package br.com.mind5.payment.statusPayOrder.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.statusPayOrderItem.info.PaytusemInfo;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info.MultmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info.PaymoipInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class PaytusMerger {	
	public static List<PaytusInfo> mergeWithUsername(List<PaytusInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilder<PaytusInfo, UsernameInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PaytusVisiMergeUsername());
		InfoMerger<PaytusInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PaytusInfo> mergeWithPaymoip(List<PaytusInfo> baseInfos, List<PaymoipInfo> selectedInfos) {
		InfoMergerBuilder<PaytusInfo, PaymoipInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PaytusVisiMergePaymoip());
		InfoMerger<PaytusInfo, PaymoipInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PaytusInfo> mergeWithPayord(List<PaytusInfo> baseInfos, List<PayordInfo> selectedInfos) {
		InfoMergerBuilder<PaytusInfo, PayordInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PaytusVisiMergePayord());
		InfoMerger<PaytusInfo, PayordInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PaytusInfo> mergeWithPaytusem(List<PaytusInfo> baseInfos, List<PaytusemInfo> selectedInfos) {
		InfoMergerBuilder<PaytusInfo, PaytusemInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PaytusVisiMergePaytusem());
		InfoMerger<PaytusInfo, PaytusemInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<PaytusInfo> mergeWithMultmoip(List<PaytusInfo> baseInfos, List<MultmoipInfo> selectedInfos) {
		InfoMergerBuilder<PaytusInfo, MultmoipInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PaytusVisiMergeMultmoip());
		InfoMerger<PaytusInfo, MultmoipInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
