package br.com.mind5.business.materialStoreSnapshot.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class MatorapMerger {
	public static List<MatorapInfo> mergeToSelect(List<MatorapInfo> baseInfos, List<MatorapInfo> selectedInfos) {
		InfoMergerBuilder<MatorapInfo, MatorapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatorapVisiMergeToSelect());
		InfoMerger<MatorapInfo, MatorapInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
