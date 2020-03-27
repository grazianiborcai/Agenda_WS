package br.com.mind5.business.employeePositionSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class EmposarchMerger {
	public static List<EmposarchInfo> mergeToSelect(List<EmposarchInfo> baseInfos, List<EmposarchInfo> selectedInfos) {
		InfoMergerBuilderV3<EmposarchInfo, EmposarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmposarchVisiMergeToSelect());
		InfoMergerV3<EmposarchInfo, EmposarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
