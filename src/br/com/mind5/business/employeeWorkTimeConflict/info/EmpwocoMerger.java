package br.com.mind5.business.employeeWorkTimeConflict.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class EmpwocoMerger {
	public static List<EmpwocoInfo> mergeToSelect(List<EmpwocoInfo> baseInfos, List<EmpwocoInfo> selectedInfos) {
		InfoMergerBuilderV3<EmpwocoInfo, EmpwocoInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpwocoVisiMergeToSelect());
		InfoMergerV3<EmpwocoInfo, EmpwocoInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
