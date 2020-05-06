package br.com.mind5.business.refundPolicyOwner.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.masterData.refundPolicy.info.RefupoInfo;

public final class RefupownMerger {
	public static List<RefupownInfo> mergeWithRefupo(List<RefupownInfo> baseInfos, List<RefupoInfo> selectedInfos) {
		InfoMergerBuilderV3<RefupownInfo, RefupoInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new RefupownVisiMergeRefupo());
		InfoMergerV3<RefupownInfo, RefupoInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
