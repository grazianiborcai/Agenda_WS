package br.com.mind5.paymentPartner.partnerMoip.permissionMoip.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.paymentPartner.partnerMoip.tokenMoip.info.TokemoipInfo;

public final class PeresmoipMerger {
	public static List<PeresmoipInfo> mergeWithTokemoip(List<PeresmoipInfo> baseInfos, List<TokemoipInfo> selectedInfos) {
		InfoMergerBuilderV3<PeresmoipInfo, TokemoipInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PeresmoipVisiMergeTokemoip());
		InfoMergerV3<PeresmoipInfo, TokemoipInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PeresmoipInfo> mergeToSelect(List<PeresmoipInfo> baseInfos, List<PeresmoipInfo> selectedInfos) {
		InfoMergerBuilderV3<PeresmoipInfo, PeresmoipInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PeresmoipVisiMergeToSelect());
		InfoMergerV3<PeresmoipInfo, PeresmoipInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
