package br.com.mind5.business.employeeLunchTimeSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class EmplutmarchMerger {	
	public static List<EmplutmarchInfo> mergeToSelect(List<EmplutmarchInfo> baseInfos, List<EmplutmarchInfo> selectedInfos) {
		InfoMergerBuilder<EmplutmarchInfo, EmplutmarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmplutmarchMergerVisiToSelect());
		InfoMerger<EmplutmarchInfo, EmplutmarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
