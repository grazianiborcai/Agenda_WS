package br.com.mind5.business.materialSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class MatarchMerger {
	public static List<MatarchInfo> mergeToSelect(List<MatarchInfo> baseInfos, List<MatarchInfo> selectedInfos) {
		InfoMergerBuilder<MatarchInfo, MatarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatarchMergerVisiToSelect());
		InfoMerger<MatarchInfo, MatarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
