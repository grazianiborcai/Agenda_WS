package br.com.mind5.business.personRestricted.info;

import java.util.List;

import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;

public final class PersoresMerger {
	public static List<PersoresInfo> mergeWithPersolis(List<PersoresInfo> baseInfos, List<PersolisInfo> selectedInfos) {
		InfoMergerBuilder<PersoresInfo, PersolisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PersoresVisiMergePersolis());
		InfoMerger<PersoresInfo, PersolisInfo> merger = builder.build();		
	
		return merger.merge();
	} 
}
