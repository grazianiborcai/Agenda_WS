package br.com.mind5.business.employeeSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class EmparchMerger {
	public static List<EmparchInfo> mergeToSelect(List<EmparchInfo> baseInfos, List<EmparchInfo> selectedInfos) {
		InfoMergerBuilderV3<EmparchInfo, EmparchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmparchVisiMergeToSelect());
		InfoMergerV3<EmparchInfo, EmparchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
