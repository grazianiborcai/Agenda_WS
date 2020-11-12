package br.com.mind5.business.employeeWorkTimeRange.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class EmpworgMerger {
	public static List<EmpworgInfo> mergeToSelect(List<EmpworgInfo> baseInfos, List<EmpworgInfo> selectedInfos) {
		InfoMergerBuilderV3<EmpworgInfo, EmpworgInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpworgVisiMergeToSelect());
		InfoMergerV3<EmpworgInfo, EmpworgInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
