package br.com.mind5.business.employeeLeaveDateSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class EmplarchMerger {
	public static List<EmplarchInfo> mergeToSelect(List<EmplarchInfo> baseInfos, List<EmplarchInfo> selectedInfos) {
		InfoMergerBuilder<EmplarchInfo, EmplarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmplarchMergerVisiToSelect());
		InfoMerger<EmplarchInfo, EmplarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
