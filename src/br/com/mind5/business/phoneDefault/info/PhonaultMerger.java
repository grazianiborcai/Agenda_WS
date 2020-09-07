package br.com.mind5.business.phoneDefault.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class PhonaultMerger {	
	public static List<PhonaultInfo> mergeToSelect(List<PhonaultInfo> baseInfos, List<PhonaultInfo> selectedInfos) {
		InfoMergerBuilderV3<PhonaultInfo, PhonaultInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PhonaultVisiMergeToSelect());
		InfoMergerV3<PhonaultInfo, PhonaultInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
