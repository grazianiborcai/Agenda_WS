package br.com.mind5.business.materialCatalogue.info;

import java.util.List;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class MatogueMerger {
	public static List<MatogueInfo> mergeWithMatore(List<MatogueInfo> baseInfos, List<MatoreInfo> selectedInfos) {
		InfoMergerBuilderV3<MatogueInfo, MatoreInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatogueVisiMergeMatore());
		InfoMergerV3<MatogueInfo, MatoreInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
