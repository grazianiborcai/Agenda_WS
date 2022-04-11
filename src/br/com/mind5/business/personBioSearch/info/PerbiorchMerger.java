package br.com.mind5.business.personBioSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;

public final class PerbiorchMerger {
	public static List<PerbiorchInfo> mergeToSelect(List<PerbiorchInfo> baseInfos, List<PerbiorchInfo> selectedInfos) {
		InfoMergerBuilder<PerbiorchInfo, PerbiorchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PerbiorchMergerVisiToSelect());
		InfoMerger<PerbiorchInfo, PerbiorchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
