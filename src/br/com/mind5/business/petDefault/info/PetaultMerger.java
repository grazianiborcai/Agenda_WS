package br.com.mind5.business.petDefault.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class PetaultMerger {	
	public static List<PetaultInfo> mergeToSelect(List<PetaultInfo> baseInfos, List<PetaultInfo> selectedInfos) {
		InfoMergerBuilder<PetaultInfo, PetaultInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PetaultMergerVisiToSelect());
		InfoMerger<PetaultInfo, PetaultInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
