package br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.masterData.sysEnvironment.info.SysenvInfo;
import br.com.mind5.payment.payOrderItemList.info.PayordemistInfo;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info.PaymoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipInfo;

public final class MultmoipMerger {
	public static List<MultmoipInfo> mergeWithPayordemist(List<MultmoipInfo> baseInfos, List<PayordemistInfo> selectedInfos) {
		InfoMergerBuilderV3<MultmoipInfo, PayordemistInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MultmoipVisiMergePayordemist());
		InfoMergerV3<MultmoipInfo, PayordemistInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<MultmoipInfo> mergeWithSysenv(List<MultmoipInfo> baseInfos, List<SysenvInfo> selectedInfos) {
		InfoMergerBuilderV3<MultmoipInfo, SysenvInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MultmoipVisiMergeSysenv());
		InfoMergerV3<MultmoipInfo, SysenvInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<MultmoipInfo> mergeWithSetupar(List<MultmoipInfo> baseInfos, List<SetuparInfo> selectedInfos) {
		InfoMergerBuilderV3<MultmoipInfo, SetuparInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MultmoipVisiMergeSetupar());
		InfoMergerV3<MultmoipInfo, SetuparInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MultmoipInfo> mergeWithOrdmoip(List<MultmoipInfo> baseInfos, List<OrdmoipInfo> selectedInfos) {
		InfoMergerBuilderV3<MultmoipInfo, OrdmoipInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MultmoipVisiMergeOrdmoip());
		InfoMergerV3<MultmoipInfo, OrdmoipInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<MultmoipInfo> mergeWithPaymoip(List<MultmoipInfo> baseInfos, List<PaymoipInfo> selectedInfos) {
		InfoMergerBuilderV3<MultmoipInfo, PaymoipInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MultmoipVisiMergePaymoip());
		InfoMergerV3<MultmoipInfo, PaymoipInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
