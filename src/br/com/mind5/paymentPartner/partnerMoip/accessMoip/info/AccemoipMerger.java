package br.com.mind5.paymentPartner.partnerMoip.accessMoip.info;

import java.util.List;

import br.com.mind5.business.masterData.info.SysEnvironInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;
import br.com.mind5.payment.systemPartner.info.SysparInfo;

public final class AccemoipMerger {
	public static List<AccemoipInfo> mergeWithSysEnviron(List<AccemoipInfo> baseInfos, List<SysEnvironInfo> selectedInfos) {
		InfoMergerBuilderV3<AccemoipInfo, SysEnvironInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new AccemoipVisiMergeSysEnviron());
		InfoMergerV3<AccemoipInfo, SysEnvironInfo> merger = builder.build();		
	
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
