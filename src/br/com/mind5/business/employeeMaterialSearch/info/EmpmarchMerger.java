package br.com.mind5.business.employeeMaterialSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class EmpmarchMerger {
	public static List<EmpmarchInfo> mergeToSelect(List<EmpmarchInfo> baseInfos, List<EmpmarchInfo> selectedInfos) {
		InfoMergerBuilderV3<EmpmarchInfo, EmpmarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpmarchVisiMergeToSelect());
		InfoMergerV3<EmpmarchInfo, EmpmarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
