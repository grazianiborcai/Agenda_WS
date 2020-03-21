package br.com.mind5.business.personList.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class PersolisMerger {
	public static List<PersolisInfo> mergeToSelect(List<PersolisInfo> baseInfos, List<PersolisInfo> selectedInfos) {
		InfoMergerBuilderV3<PersolisInfo, PersolisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PersolisVisiMergeToSelect());
		InfoMergerV3<PersolisInfo, PersolisInfo> merger = builder.build();		
	
		return merger.merge();
	} 
}
