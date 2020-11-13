package br.com.mind5.business.phoneDefault.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class PhonaultMerger {	
	public static List<PhonaultInfo> mergeToSelect(List<PhonaultInfo> baseInfos, List<PhonaultInfo> selectedInfos) {
		InfoMergerBuilder<PhonaultInfo, PhonaultInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PhonaultVisiMergeToSelect());
		InfoMerger<PhonaultInfo, PhonaultInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
