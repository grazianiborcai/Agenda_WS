package br.com.mind5.business.materialCatalogue.info;

import java.util.List;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class MatogueMerger {
	public static List<MatogueInfo> mergeWithMatore(List<MatogueInfo> baseInfos, List<MatoreInfo> selectedInfos) {
		InfoMergerBuilder<MatogueInfo, MatoreInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatogueVisiMergeMatore());
		InfoMerger<MatogueInfo, MatoreInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
