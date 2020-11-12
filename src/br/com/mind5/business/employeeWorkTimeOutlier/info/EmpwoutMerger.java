package br.com.mind5.business.employeeWorkTimeOutlier.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class EmpwoutMerger {
	public static List<EmpwoutInfo> mergeToSelect(List<EmpwoutInfo> baseInfos, List<EmpwoutInfo> selectedInfos) {
		InfoMergerBuilderV3<EmpwoutInfo, EmpwoutInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpwoutVisiMergeToSelect());
		InfoMergerV3<EmpwoutInfo, EmpwoutInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
