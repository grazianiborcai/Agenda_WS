package br.com.mind5.paymentPartner.partnerMoip.refundMoip.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.masterData.sysEnvironment.info.SysenvInfo;
import br.com.mind5.payment.payOrderItemList.info.PayordemistInfo;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;
import br.com.mind5.payment.storePartner.info.StoparInfo;

public final class RefumoipMerger {
	public static List<RefumoipInfo> mergeWithPayordemist(List<RefumoipInfo> baseInfos, List<PayordemistInfo> selectedInfos) {
		InfoMergerBuilderV3<RefumoipInfo, PayordemistInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new RefumoipVisiMergePayordemist());
		InfoMergerV3<RefumoipInfo, PayordemistInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<RefumoipInfo> mergeWithSysenv(List<RefumoipInfo> baseInfos, List<SysenvInfo> selectedInfos) {
		InfoMergerBuilderV3<RefumoipInfo, SysenvInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new RefumoipVisiMergeSysenv());
		InfoMergerV3<RefumoipInfo, SysenvInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<RefumoipInfo> mergeWithSetupar(List<RefumoipInfo> baseInfos, List<SetuparInfo> selectedInfos) {
		InfoMergerBuilderV3<RefumoipInfo, SetuparInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new RefumoipVisiMergeSetupar());
		InfoMergerV3<RefumoipInfo, SetuparInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<RefumoipInfo> mergeWithStopar(List<RefumoipInfo> baseInfos, List<StoparInfo> selectedInfos) {
		InfoMergerBuilderV3<RefumoipInfo, StoparInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new RefumoipVisiMergeStopar());
		InfoMergerV3<RefumoipInfo, StoparInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
