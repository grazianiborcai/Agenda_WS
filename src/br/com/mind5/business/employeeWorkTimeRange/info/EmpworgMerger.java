package br.com.mind5.business.employeeWorkTimeRange.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class EmpworgMerger {
	public static List<EmpworgInfo> mergeToSelect(List<EmpworgInfo> baseInfos, List<EmpworgInfo> selectedInfos) {
		InfoMergerBuilder<EmpworgInfo, EmpworgInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpworgVisiMergeToSelect());
		InfoMerger<EmpworgInfo, EmpworgInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
