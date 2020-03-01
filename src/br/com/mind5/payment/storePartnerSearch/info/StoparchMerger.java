package br.com.mind5.payment.storePartnerSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class StoparchMerger {		
	public static List<StoparchInfo> mergeToSelect(List<StoparchInfo> baseInfos, List<StoparchInfo> selectedInfos) {
		InfoMergerBuilderV3<StoparchInfo, StoparchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoparchVisiMergeToSelect());
		InfoMergerV3<StoparchInfo, StoparchInfo> merger = builder.build();		
	
		return merger.merge();
	}			
}
