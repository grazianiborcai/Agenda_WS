package br.com.mind5.business.materialTextSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class MatextarchMerger {	
	public static List<MatextarchInfo> mergeToSelect(List<MatextarchInfo> baseInfos, List<MatextarchInfo> selectedInfos) {
		InfoMergerBuilderV3<MatextarchInfo, MatextarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatextarchVisiMergeToSelect());
		InfoMergerV3<MatextarchInfo, MatextarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
