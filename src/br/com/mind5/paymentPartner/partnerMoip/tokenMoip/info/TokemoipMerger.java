package br.com.mind5.paymentPartner.partnerMoip.tokenMoip.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.masterData.sysEnvironment.info.SysenvInfo;
import br.com.mind5.payment.marketplacePartner.info.MktparInfo;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;

public final class TokemoipMerger {	
	public static List<TokemoipInfo> mergeWithSysenv(List<TokemoipInfo> baseInfos, List<SysenvInfo> selectedInfos) {
		InfoMergerBuilder<TokemoipInfo, SysenvInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new TokemoipMergerVisiSysenv());
		InfoMerger<TokemoipInfo, SysenvInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<TokemoipInfo> mergeWithSetupar(List<TokemoipInfo> baseInfos, List<SetuparInfo> selectedInfos) {
		InfoMergerBuilder<TokemoipInfo, SetuparInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new TokemoipMergerVisiSetupar());
		InfoMerger<TokemoipInfo, SetuparInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<TokemoipInfo> mergeWithSyspar(List<TokemoipInfo> baseInfos, List<MktparInfo> selectedInfos) {
		InfoMergerBuilder<TokemoipInfo, MktparInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new TokemoipMergerVisiSyspar());
		InfoMerger<TokemoipInfo, MktparInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
