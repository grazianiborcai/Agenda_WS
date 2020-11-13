package br.com.mind5.business.personList.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class PersolisMerger {
	public static List<PersolisInfo> mergeToSelect(List<PersolisInfo> baseInfos, List<PersolisInfo> selectedInfos) {
		InfoMergerBuilder<PersolisInfo, PersolisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PersolisVisiMergeToSelect());
		InfoMerger<PersolisInfo, PersolisInfo> merger = builder.build();		
	
		return merger.merge();
	} 
}
