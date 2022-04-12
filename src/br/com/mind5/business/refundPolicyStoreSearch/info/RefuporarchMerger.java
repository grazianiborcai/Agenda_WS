package br.com.mind5.business.refundPolicyStoreSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class RefuporarchMerger {
	public static List<RefuporarchInfo> mergeToSelect(List<RefuporarchInfo> baseInfos, List<RefuporarchInfo> selectedInfos) {
		InfoMergerBuilder<RefuporarchInfo, RefuporarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new RefuporarchMergerVisiToSelect());
		InfoMerger<RefuporarchInfo, RefuporarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
