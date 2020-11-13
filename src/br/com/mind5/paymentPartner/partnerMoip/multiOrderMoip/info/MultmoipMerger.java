package br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.masterData.sysEnvironment.info.SysenvInfo;
import br.com.mind5.payment.payOrderItemList.info.PayordemistInfo;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info.PaymoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipInfo;

public final class MultmoipMerger {
	public static List<MultmoipInfo> mergeWithPayordemist(List<MultmoipInfo> baseInfos, List<PayordemistInfo> selectedInfos) {
		InfoMergerBuilder<MultmoipInfo, PayordemistInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MultmoipVisiMergePayordemist());
		InfoMerger<MultmoipInfo, PayordemistInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<MultmoipInfo> mergeWithSysenv(List<MultmoipInfo> baseInfos, List<SysenvInfo> selectedInfos) {
		InfoMergerBuilder<MultmoipInfo, SysenvInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MultmoipVisiMergeSysenv());
		InfoMerger<MultmoipInfo, SysenvInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<MultmoipInfo> mergeWithSetupar(List<MultmoipInfo> baseInfos, List<SetuparInfo> selectedInfos) {
		InfoMergerBuilder<MultmoipInfo, SetuparInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MultmoipVisiMergeSetupar());
		InfoMerger<MultmoipInfo, SetuparInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MultmoipInfo> mergeWithOrdmoip(List<MultmoipInfo> baseInfos, List<OrdmoipInfo> selectedInfos) {
		InfoMergerBuilder<MultmoipInfo, OrdmoipInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MultmoipVisiMergeOrdmoip());
		InfoMerger<MultmoipInfo, OrdmoipInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<MultmoipInfo> mergeWithPaymoip(List<MultmoipInfo> baseInfos, List<PaymoipInfo> selectedInfos) {
		InfoMergerBuilder<MultmoipInfo, PaymoipInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MultmoipVisiMergePaymoip());
		InfoMerger<MultmoipInfo, PaymoipInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
