package br.com.mind5.business.materialStockSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class MatocarchMerger {
	public static List<MatocarchInfo> mergeToSelect(List<MatocarchInfo> baseInfos, List<MatocarchInfo> selectedInfos) {
		InfoMergerBuilder<MatocarchInfo, MatocarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatocarchMergerVisiToSelect());
		InfoMerger<MatocarchInfo, MatocarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
