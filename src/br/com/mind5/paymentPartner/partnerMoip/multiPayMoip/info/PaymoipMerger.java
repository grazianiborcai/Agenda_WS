package br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.masterData.sysEnvironment.info.SysenvInfo;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;
import br.com.mind5.payment.systemPartner.info.SysparInfo;

public final class PaymoipMerger {
	public static List<PaymoipInfo> mergeWithSyspar(List<PaymoipInfo> baseInfos, List<SysparInfo> selectedInfos) {
		InfoMergerBuilderV3<PaymoipInfo, SysparInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PaymoipVisiMergeSyspar());
		InfoMergerV3<PaymoipInfo, SysparInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<PaymoipInfo> mergeWithCrecard(List<PaymoipInfo> baseInfos, List<CrecardInfo> selectedInfos) {
		InfoMergerBuilderV3<PaymoipInfo, CrecardInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PaymoipVisiMergeCrecard());
		InfoMergerV3<PaymoipInfo, CrecardInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<PaymoipInfo> mergeWithSetupar(List<PaymoipInfo> baseInfos, List<SetuparInfo> selectedInfos) {
		InfoMergerBuilderV3<PaymoipInfo, SetuparInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PaymoipVisiMergeSetupar());
		InfoMergerV3<PaymoipInfo, SetuparInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<PaymoipInfo> mergeWithSysenv(List<PaymoipInfo> baseInfos, List<SysenvInfo> selectedInfos) {
		InfoMergerBuilderV3<PaymoipInfo, SysenvInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PaymoipVisiMergeSysenv());
		InfoMergerV3<PaymoipInfo, SysenvInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
