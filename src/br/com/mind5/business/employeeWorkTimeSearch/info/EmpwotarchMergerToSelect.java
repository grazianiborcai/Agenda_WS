package br.com.mind5.business.employeeWorkTimeSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;

final class EmpwotarchMergerToSelect extends InfoMergerTemplate_<EmpwotarchInfo, EmpwotarchInfo> {
	public static List<EmpwotarchInfo> mergeToSelect(List<EmpwotarchInfo> baseInfos, List<EmpwotarchInfo> selectedInfos) {
		InfoMergerBuilderV3<EmpwotarchInfo, EmpwotarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpwotarchVisiMergeToSelect());
		InfoMergerV3<EmpwotarchInfo, EmpwotarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
