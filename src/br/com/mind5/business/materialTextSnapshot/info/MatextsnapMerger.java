package br.com.mind5.business.materialTextSnapshot.info;

import java.util.List;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class MatextsnapMerger {
	public static List<MatextsnapInfo> mergeWithMatext(List<MatextsnapInfo> baseInfos, List<MatextInfo> selectedInfos) {
		InfoMergerBuilderV3<MatextsnapInfo, MatextInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatextsnapVisiMergeMatext());
		InfoMergerV3<MatextsnapInfo, MatextInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	
	public static List<MatextsnapInfo> mergeToSelect(List<MatextsnapInfo> baseInfos, List<MatextsnapInfo> selectedInfos) {
		InfoMergerBuilderV3<MatextsnapInfo, MatextsnapInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatextsnapVisiMergeToSelect());
		InfoMergerV3<MatextsnapInfo, MatextsnapInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
