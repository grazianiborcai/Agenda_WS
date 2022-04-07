package br.com.mind5.business.employeeSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class EmparchMerger {
	public static List<EmparchInfo> mergeToSelect(List<EmparchInfo> baseInfos, List<EmparchInfo> selectedInfos) {
		InfoMergerBuilder<EmparchInfo, EmparchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmparchMergerVisiToSelect());
		InfoMerger<EmparchInfo, EmparchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
