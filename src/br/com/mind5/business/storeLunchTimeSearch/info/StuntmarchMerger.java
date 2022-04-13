package br.com.mind5.business.storeLunchTimeSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class StuntmarchMerger {
	public static List<StuntmarchInfo> mergeToSelect(List<StuntmarchInfo> baseInfos, List<StuntmarchInfo> selectedInfos) {
		InfoMergerBuilder<StuntmarchInfo, StuntmarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StuntmarchMergerVisiToSelect());
		InfoMerger<StuntmarchInfo, StuntmarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
