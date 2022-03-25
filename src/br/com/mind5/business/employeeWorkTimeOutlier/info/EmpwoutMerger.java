package br.com.mind5.business.employeeWorkTimeOutlier.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class EmpwoutMerger {
	public static List<EmpwoutInfo> mergeToSelect(List<EmpwoutInfo> baseInfos, List<EmpwoutInfo> selectedInfos) {
		InfoMergerBuilder<EmpwoutInfo, EmpwoutInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpwoutMergerVisiToSelect());
		InfoMerger<EmpwoutInfo, EmpwoutInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
