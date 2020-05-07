package br.com.mind5.business.refundPolicyOwner.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.masterData.refundPolicyGroup.info.RefugroupInfo;

public final class RefupownMerger {
	public static List<RefupownInfo> mergeWithRefugroup(List<RefupownInfo> baseInfos, List<RefugroupInfo> selectedInfos) {
		InfoMergerBuilderV3<RefupownInfo, RefugroupInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new RefupownVisiMergeRefugroup());
		InfoMergerV3<RefupownInfo, RefugroupInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
