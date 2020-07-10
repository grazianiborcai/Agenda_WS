package br.com.mind5.business.employeeLeaveDateSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class EmplarchMerger {
	public static List<EmplarchInfo> mergeToSelect(List<EmplarchInfo> baseInfos, List<EmplarchInfo> selectedInfos) {
		InfoMergerBuilderV3<EmplarchInfo, EmplarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmplarchVisiMergeToSelect());
		InfoMergerV3<EmplarchInfo, EmplarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
