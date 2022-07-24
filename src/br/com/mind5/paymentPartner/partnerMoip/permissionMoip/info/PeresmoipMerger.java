package br.com.mind5.paymentPartner.partnerMoip.permissionMoip.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.paymentPartner.partnerMoip.tokenMoip.info.TokemoipInfo;

public final class PeresmoipMerger {
	public static List<PeresmoipInfo> mergeWithTokemoip(List<PeresmoipInfo> baseInfos, List<TokemoipInfo> selectedInfos) {
		InfoMergerBuilder<PeresmoipInfo, TokemoipInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PeresmoipMergerVisiTokemoip());
		InfoMerger<PeresmoipInfo, TokemoipInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PeresmoipInfo> mergeToSelect(List<PeresmoipInfo> baseInfos, List<PeresmoipInfo> selectedInfos) {
		InfoMergerBuilder<PeresmoipInfo, PeresmoipInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PeresmoipMergerVisiToSelect());
		InfoMerger<PeresmoipInfo, PeresmoipInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
