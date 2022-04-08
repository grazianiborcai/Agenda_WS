package br.com.mind5.business.materialStoreSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class MatorarchMerger {
	public static List<MatorarchInfo> mergeToSelect(List<MatorarchInfo> baseInfos, List<MatorarchInfo> selectedInfos) {
		InfoMergerBuilder<MatorarchInfo, MatorarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatorarchMergerVisiToSelect());
		InfoMerger<MatorarchInfo, MatorarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
