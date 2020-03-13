package br.com.mind5.business.materialSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class MatarchMerger {
	public static List<MatarchInfo> mergeToSelect(List<MatarchInfo> baseInfos, List<MatarchInfo> selectedInfos) {
		InfoMergerBuilderV3<MatarchInfo, MatarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatarchVisiMergeToSelect());
		InfoMergerV3<MatarchInfo, MatarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
