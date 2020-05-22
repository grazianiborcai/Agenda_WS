package br.com.mind5.paymentPartner.partnerMoip.accessMoip.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.masterData.sysEnvironment.info.SysenvInfo;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;
import br.com.mind5.payment.systemPartner.info.SysparInfo;

public final class AccemoipMerger {
	public static List<AccemoipInfo> mergeWithSysenv(List<AccemoipInfo> baseInfos, List<SysenvInfo> selectedInfos) {
		InfoMergerBuilderV3<AccemoipInfo, SysenvInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new AccemoipVisiMergeSysenv());
		InfoMergerV3<AccemoipInfo, SysenvInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<AccemoipInfo> mergeWithSetupar(List<AccemoipInfo> baseInfos, List<SetuparInfo> selectedInfos) {
		InfoMergerBuilderV3<AccemoipInfo, SetuparInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new AccemoipVisiMergeSetupar());
		InfoMergerV3<AccemoipInfo, SetuparInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<AccemoipInfo> mergeWithSyspar(List<AccemoipInfo> baseInfos, List<SysparInfo> selectedInfos) {
		InfoMergerBuilderV3<AccemoipInfo, SysparInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new AccemoipVisiMergeSyspar());
		InfoMergerV3<AccemoipInfo, SysparInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
