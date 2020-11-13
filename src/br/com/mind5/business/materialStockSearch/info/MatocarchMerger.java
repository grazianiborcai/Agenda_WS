package br.com.mind5.business.materialStockSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class MatocarchMerger {
	public static List<MatocarchInfo> mergeToSelect(List<MatocarchInfo> baseInfos, List<MatocarchInfo> selectedInfos) {
		InfoMergerBuilderV3<MatocarchInfo, MatocarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatocarchVisiMergeToSelect());
		InfoMergerV3<MatocarchInfo, MatocarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
