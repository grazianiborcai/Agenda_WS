package br.com.mind5.paymentPartner.partnerMoip.tokenMoip.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.masterData.sysEnvironment.info.SysenvInfo;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;
import br.com.mind5.payment.systemPartner.info.SysparInfo;

public final class TokemoipMerger {	
	public static List<TokemoipInfo> mergeWithSysenv(List<TokemoipInfo> baseInfos, List<SysenvInfo> selectedInfos) {
		InfoMergerBuilder<TokemoipInfo, SysenvInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new TokemoipVisiMergeSysenv());
		InfoMerger<TokemoipInfo, SysenvInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<TokemoipInfo> mergeWithSetupar(List<TokemoipInfo> baseInfos, List<SetuparInfo> selectedInfos) {
		InfoMergerBuilder<TokemoipInfo, SetuparInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new TokemoipVisiMergeSetupar());
		InfoMerger<TokemoipInfo, SetuparInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<TokemoipInfo> mergeWithSyspar(List<TokemoipInfo> baseInfos, List<SysparInfo> selectedInfos) {
		InfoMergerBuilder<TokemoipInfo, SysparInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new TokemoipVisiMergeSyspar());
		InfoMerger<TokemoipInfo, SysparInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
