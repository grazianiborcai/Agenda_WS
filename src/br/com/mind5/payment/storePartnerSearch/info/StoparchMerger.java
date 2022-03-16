package br.com.mind5.payment.storePartnerSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class StoparchMerger {		
	public static List<StoparchInfo> mergeToSelect(List<StoparchInfo> baseInfos, List<StoparchInfo> selectedInfos) {
		InfoMergerBuilder<StoparchInfo, StoparchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoparchMergerVisiToSelect());
		InfoMerger<StoparchInfo, StoparchInfo> merger = builder.build();		
	
		return merger.merge();
	}			
}
