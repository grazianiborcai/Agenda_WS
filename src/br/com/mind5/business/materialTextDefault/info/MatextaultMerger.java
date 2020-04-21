package br.com.mind5.business.materialTextDefault.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class MatextaultMerger {	
	public static List<MatextaultInfo> mergeToSelect(List<MatextaultInfo> baseInfos, List<MatextaultInfo> selectedInfos) {
		InfoMergerBuilderV3<MatextaultInfo, MatextaultInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatextaultVisiMergeToSelect());
		InfoMergerV3<MatextaultInfo, MatextaultInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
