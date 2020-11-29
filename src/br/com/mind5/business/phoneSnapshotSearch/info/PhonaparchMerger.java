package br.com.mind5.business.phoneSnapshotSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;

public final class PhonaparchMerger {
	public static List<PhonaparchInfo> mergeToSelect(List<PhonaparchInfo> baseInfos, List<PhonaparchInfo> selectedInfos) {
		InfoMergerBuilder<PhonaparchInfo, PhonaparchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PhonaparchVisiMergeToSelect());
		InfoMerger<PhonaparchInfo, PhonaparchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
