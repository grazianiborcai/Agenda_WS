package br.com.mind5.business.materialTextDefault.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class MatextaultMerger {	
	public static List<MatextaultInfo> mergeToSelect(List<MatextaultInfo> baseInfos, List<MatextaultInfo> selectedInfos) {
		InfoMergerBuilder<MatextaultInfo, MatextaultInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatextaultMergerVisiToSelect());
		InfoMerger<MatextaultInfo, MatextaultInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
