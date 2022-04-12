package br.com.mind5.business.personBioSnapshot.info;

import java.util.List;

import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;

public final class PerbionapMerger {
	public static List<PerbionapInfo> mergeToSelect(List<PerbionapInfo> baseInfos, List<PerbionapInfo> selectedInfos) {
		InfoMergerBuilder<PerbionapInfo, PerbionapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PerbionapMergerVisiToSelect());
		InfoMerger<PerbionapInfo, PerbionapInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
