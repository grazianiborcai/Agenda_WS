package br.com.mind5.business.refundPolicyStoreSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class RefuporarchMerger {
	public static List<RefuporarchInfo> mergeToSelect(List<RefuporarchInfo> baseInfos, List<RefuporarchInfo> selectedInfos) {
		InfoMergerBuilderV3<RefuporarchInfo, RefuporarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new RefuporarchVisiMergeToSelect());
		InfoMergerV3<RefuporarchInfo, RefuporarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
