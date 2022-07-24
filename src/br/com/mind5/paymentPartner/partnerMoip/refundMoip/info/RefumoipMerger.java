package br.com.mind5.paymentPartner.partnerMoip.refundMoip.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.masterData.sysEnvironment.info.SysenvInfo;
import br.com.mind5.payment.payOrderItemList.info.PayordemistInfo;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;
import br.com.mind5.payment.storePartner.info.StoparInfo;

public final class RefumoipMerger {
	public static List<RefumoipInfo> mergeWithPayordemist(List<RefumoipInfo> baseInfos, List<PayordemistInfo> selectedInfos) {
		InfoMergerBuilder<RefumoipInfo, PayordemistInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new RefumoipMergerVisiPayordemist());
		InfoMerger<RefumoipInfo, PayordemistInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<RefumoipInfo> mergeWithSysenv(List<RefumoipInfo> baseInfos, List<SysenvInfo> selectedInfos) {
		InfoMergerBuilder<RefumoipInfo, SysenvInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new RefumoipMergerVisiSysenv());
		InfoMerger<RefumoipInfo, SysenvInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<RefumoipInfo> mergeWithSetupar(List<RefumoipInfo> baseInfos, List<SetuparInfo> selectedInfos) {
		InfoMergerBuilder<RefumoipInfo, SetuparInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new RefumoipMergerVisiSetupar());
		InfoMerger<RefumoipInfo, SetuparInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<RefumoipInfo> mergeWithStopar(List<RefumoipInfo> baseInfos, List<StoparInfo> selectedInfos) {
		InfoMergerBuilder<RefumoipInfo, StoparInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new RefumoipMergerVisiStopar());
		InfoMerger<RefumoipInfo, StoparInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
