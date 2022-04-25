package br.com.mind5.business.employeeLunchTimeConflict.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class EmpulocoMerger {
	public static List<EmpulocoInfo> mergeToSelect(List<EmpulocoInfo> baseInfos, List<EmpulocoInfo> selectedInfos) {
		InfoMergerBuilder<EmpulocoInfo, EmpulocoInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpulocoMergerVisiToSelect());
		InfoMerger<EmpulocoInfo, EmpulocoInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
