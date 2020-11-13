package br.com.mind5.business.materialTextSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class MatextarchMerger {	
	public static List<MatextarchInfo> mergeToSelect(List<MatextarchInfo> baseInfos, List<MatextarchInfo> selectedInfos) {
		InfoMergerBuilder<MatextarchInfo, MatextarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatextarchVisiMergeToSelect());
		InfoMerger<MatextarchInfo, MatextarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
