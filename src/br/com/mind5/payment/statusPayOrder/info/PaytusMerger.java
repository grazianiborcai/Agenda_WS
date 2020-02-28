package br.com.mind5.payment.statusPayOrder.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.statusPayOrderItem.info.PaytusemInfo;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info.MultmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info.PaymoipInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class PaytusMerger {	
	public static List<PaytusInfo> mergeWithUsername(List<PaytusInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilderV3<PaytusInfo, UsernameInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PaytusVisiMergeUsername());
		InfoMergerV3<PaytusInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PaytusInfo> mergeWithPaymoip(List<PaytusInfo> baseInfos, List<PaymoipInfo> selectedInfos) {
		InfoMergerBuilderV3<PaytusInfo, PaymoipInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PaytusVisiMergePaymoip());
		InfoMergerV3<PaytusInfo, PaymoipInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PaytusInfo> mergeWithPayord(List<PaytusInfo> baseInfos, List<PayordInfo> selectedInfos) {
		InfoMergerBuilderV3<PaytusInfo, PayordInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PaytusVisiMergePayord());
		InfoMergerV3<PaytusInfo, PayordInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PaytusInfo> mergeWithPaytusem(List<PaytusInfo> baseInfos, List<PaytusemInfo> selectedInfos) {
		InfoMergerBuilderV3<PaytusInfo, PaytusemInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PaytusVisiMergePaytusem());
		InfoMergerV3<PaytusInfo, PaytusemInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<PaytusInfo> mergeWithMultmoip(List<PaytusInfo> baseInfos, List<MultmoipInfo> selectedInfos) {
		InfoMergerBuilderV3<PaytusInfo, MultmoipInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PaytusVisiMergeMultmoip());
		InfoMergerV3<PaytusInfo, MultmoipInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
