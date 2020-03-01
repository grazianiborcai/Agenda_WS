package br.com.mind5.paymentPartner.partnerMoip.refundMoip.info;

import java.util.List;

import br.com.mind5.business.masterData.info.SysEnvironInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;
import br.com.mind5.payment.storePartner.info.StoparInfo;

public final class RefumoipMerger {
	public static List<RefumoipInfo> mergeWithSysEnviron(List<RefumoipInfo> baseInfos, List<SysEnvironInfo> selectedInfos) {
		InfoMergerBuilderV3<RefumoipInfo, SysEnvironInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new RefumoipVisiMergeSysEnviron());
		InfoMergerV3<RefumoipInfo, SysEnvironInfo> merger = builder.build();		
	
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
