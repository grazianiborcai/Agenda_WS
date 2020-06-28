package br.com.mind5.business.companySnapshot.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class CompnapMerger {
	public static List<CompnapInfo> mergeToSelect(List<CompnapInfo> baseInfos, List<CompnapInfo> selectedInfos) {
		InfoMergerBuilderV3<CompnapInfo, CompnapInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CompnapVisiMergeToSelect());
		InfoMergerV3<CompnapInfo, CompnapInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
