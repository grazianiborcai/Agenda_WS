package br.com.mind5.business.materialTextSnapshot.info;

import java.util.List;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class MatextsnapMerger {
	public static List<MatextsnapInfo> mergeWithMatext(List<MatextsnapInfo> baseInfos, List<MatextInfo> selectedInfos) {
		InfoMergerBuilder<MatextsnapInfo, MatextInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatextsnapVisiMergeMatext());
		InfoMerger<MatextsnapInfo, MatextInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	
	public static List<MatextsnapInfo> mergeToSelect(List<MatextsnapInfo> baseInfos, List<MatextsnapInfo> selectedInfos) {
		InfoMergerBuilder<MatextsnapInfo, MatextsnapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatextsnapVisiMergeToSelect());
		InfoMerger<MatextsnapInfo, MatextsnapInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
