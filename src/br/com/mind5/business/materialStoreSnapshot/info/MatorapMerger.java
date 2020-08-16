package br.com.mind5.business.materialStoreSnapshot.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class MatorapMerger {
	public static List<MatorapInfo> mergeToSelect(List<MatorapInfo> baseInfos, List<MatorapInfo> selectedInfos) {
		InfoMergerBuilderV3<MatorapInfo, MatorapInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatorapVisiMergeToSelect());
		InfoMergerV3<MatorapInfo, MatorapInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
