package br.com.mind5.business.employeePositionSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class EmposarchMerger {
	public static List<EmposarchInfo> mergeToSelect(List<EmposarchInfo> baseInfos, List<EmposarchInfo> selectedInfos) {
		InfoMergerBuilder<EmposarchInfo, EmposarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmposarchMergerVisiToSelect());
		InfoMerger<EmposarchInfo, EmposarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
