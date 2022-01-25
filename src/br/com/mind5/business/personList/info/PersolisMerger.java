package br.com.mind5.business.personList.info;

import java.util.List;

import br.com.mind5.business.personBioList.info.PerbiolisInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;

public final class PersolisMerger {
	public static List<PersolisInfo> mergeWithPerbiolis(List<PersolisInfo> baseInfos, List<PerbiolisInfo> selectedInfos) {
		InfoMergerBuilder<PersolisInfo, PerbiolisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PersolisVisiMergePerbiolis());
		InfoMerger<PersolisInfo, PerbiolisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PersolisInfo> mergeToSelect(List<PersolisInfo> baseInfos, List<PersolisInfo> selectedInfos) {
		InfoMergerBuilder<PersolisInfo, PersolisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PersolisVisiMergeToSelect());
		InfoMerger<PersolisInfo, PersolisInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
