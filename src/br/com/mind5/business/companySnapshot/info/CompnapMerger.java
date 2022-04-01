package br.com.mind5.business.companySnapshot.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class CompnapMerger {
	public static List<CompnapInfo> mergeToSelect(List<CompnapInfo> baseInfos, List<CompnapInfo> selectedInfos) {
		InfoMergerBuilder<CompnapInfo, CompnapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CompnapMergerVisiToSelect());
		InfoMerger<CompnapInfo, CompnapInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
