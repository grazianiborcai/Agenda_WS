package br.com.mind5.business.employeeMaterialSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class EmpmarchMerger {
	public static List<EmpmarchInfo> mergeToSelect(List<EmpmarchInfo> baseInfos, List<EmpmarchInfo> selectedInfos) {
		InfoMergerBuilder<EmpmarchInfo, EmpmarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpmarchVisiMergeToSelect());
		InfoMerger<EmpmarchInfo, EmpmarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
