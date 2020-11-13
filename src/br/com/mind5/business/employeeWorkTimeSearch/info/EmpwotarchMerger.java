package br.com.mind5.business.employeeWorkTimeSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class EmpwotarchMerger {	
	public static List<EmpwotarchInfo> mergeToSelect(List<EmpwotarchInfo> baseInfos, List<EmpwotarchInfo> selectedInfos) {
		InfoMergerBuilder<EmpwotarchInfo, EmpwotarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpwotarchVisiMergeToSelect());
		InfoMerger<EmpwotarchInfo, EmpwotarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
