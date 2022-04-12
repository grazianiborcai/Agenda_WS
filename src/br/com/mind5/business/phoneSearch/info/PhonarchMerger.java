package br.com.mind5.business.phoneSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class PhonarchMerger {	
	public static List<PhonarchInfo> mergeToSelect(List<PhonarchInfo> baseInfos, List<PhonarchInfo> selectedInfos) {
		InfoMergerBuilder<PhonarchInfo, PhonarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PhonarchMergerVisiToSelect());
		InfoMerger<PhonarchInfo, PhonarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
