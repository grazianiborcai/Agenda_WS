package br.com.mind5.business.materialMovementSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class MatmarchMerger {
	public static List<MatmarchInfo> mergeToSelect(List<MatmarchInfo> baseInfos, List<MatmarchInfo> selectedInfos) {
		InfoMergerBuilderV3<MatmarchInfo, MatmarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatmarchVisiMergeToSelect());
		InfoMergerV3<MatmarchInfo, MatmarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
