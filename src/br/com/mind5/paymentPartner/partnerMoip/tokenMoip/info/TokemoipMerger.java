package br.com.mind5.paymentPartner.partnerMoip.tokenMoip.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.masterData.sysEnvironment.info.SysenvInfo;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;
import br.com.mind5.payment.systemPartner.info.SysparInfo;

public final class TokemoipMerger {	
	public static List<TokemoipInfo> mergeWithSysenv(List<TokemoipInfo> baseInfos, List<SysenvInfo> selectedInfos) {
		InfoMergerBuilderV3<TokemoipInfo, SysenvInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new TokemoipVisiMergeSysenv());
		InfoMergerV3<TokemoipInfo, SysenvInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<TokemoipInfo> mergeWithSetupar(List<TokemoipInfo> baseInfos, List<SetuparInfo> selectedInfos) {
		InfoMergerBuilderV3<TokemoipInfo, SetuparInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new TokemoipVisiMergeSetupar());
		InfoMergerV3<TokemoipInfo, SetuparInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<TokemoipInfo> mergeWithSyspar(List<TokemoipInfo> baseInfos, List<SysparInfo> selectedInfos) {
		InfoMergerBuilderV3<TokemoipInfo, SysparInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new TokemoipVisiMergeSyspar());
		InfoMergerV3<TokemoipInfo, SysparInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
