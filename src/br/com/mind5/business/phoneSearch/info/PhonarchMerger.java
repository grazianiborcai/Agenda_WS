package br.com.mind5.business.phoneSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class PhonarchMerger {	
	public static List<PhonarchInfo> mergeToSelect(List<PhonarchInfo> baseInfos, List<PhonarchInfo> selectedInfos) {
		InfoMergerBuilderV3<PhonarchInfo, PhonarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PhonarchVisiMergeToSelect());
		InfoMergerV3<PhonarchInfo, PhonarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
