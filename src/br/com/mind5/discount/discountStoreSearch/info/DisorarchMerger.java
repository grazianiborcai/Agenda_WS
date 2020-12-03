package br.com.mind5.discount.discountStoreSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;

public final class DisorarchMerger {
	public static List<DisorarchInfo> mergeToSelect(List<DisorarchInfo> baseInfos, List<DisorarchInfo> selectedInfos) {
		InfoMergerBuilder<DisorarchInfo, DisorarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new DisorarchVisiMergeToSelect());
		InfoMerger<DisorarchInfo, DisorarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
