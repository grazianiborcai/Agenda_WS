package br.com.mind5.business.materialStoreSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class MatorarchMerger {
	public static List<MatorarchInfo> mergeToSelect(List<MatorarchInfo> baseInfos, List<MatorarchInfo> selectedInfos) {
		InfoMergerBuilderV3<MatorarchInfo, MatorarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatorarchVisiMergeToSelect());
		InfoMergerV3<MatorarchInfo, MatorarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
