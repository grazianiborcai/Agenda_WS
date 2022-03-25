package br.com.mind5.business.employeeWorkTimeConflict.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class EmpwocoMerger {
	public static List<EmpwocoInfo> mergeToSelect(List<EmpwocoInfo> baseInfos, List<EmpwocoInfo> selectedInfos) {
		InfoMergerBuilder<EmpwocoInfo, EmpwocoInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpwocoMergeRVisiToSelect());
		InfoMerger<EmpwocoInfo, EmpwocoInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
