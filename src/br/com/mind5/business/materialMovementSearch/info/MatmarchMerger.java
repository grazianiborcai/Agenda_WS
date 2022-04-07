package br.com.mind5.business.materialMovementSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class MatmarchMerger {
	public static List<MatmarchInfo> mergeToSelect(List<MatmarchInfo> baseInfos, List<MatmarchInfo> selectedInfos) {
		InfoMergerBuilder<MatmarchInfo, MatmarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatmarchMergerVisiToSelect());
		InfoMerger<MatmarchInfo, MatmarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
