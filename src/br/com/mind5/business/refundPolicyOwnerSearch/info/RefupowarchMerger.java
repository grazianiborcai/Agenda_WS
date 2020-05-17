package br.com.mind5.business.refundPolicyOwnerSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class RefupowarchMerger {
	public static List<RefupowarchInfo> mergeToSelect(List<RefupowarchInfo> baseInfos, List<RefupowarchInfo> selectedInfos) {
		InfoMergerBuilderV3<RefupowarchInfo, RefupowarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new RefupowarchVisiMergeToSelect());
		InfoMergerV3<RefupowarchInfo, RefupowarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
