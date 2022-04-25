package br.com.mind5.business.employeeLunchTimeConflict.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class EmpulranMerger {
	public static List<EmpulranInfo> mergeToSelect(List<EmpulranInfo> baseInfos, List<EmpulranInfo> selectedInfos) {
		InfoMergerBuilder<EmpulranInfo, EmpulranInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpulranMergerVisiToSelect());
		InfoMerger<EmpulranInfo, EmpulranInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
