package br.com.mind5.business.materialStock.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class MatockMerger {
	public static List<MatockInfo> mergeToSelect(List<MatockInfo> baseInfos, List<MatockInfo> selectedInfos) {
		InfoMergerBuilderV3<MatockInfo, MatockInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatockVisiMergeToSelect());
		InfoMergerV3<MatockInfo, MatockInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatockInfo> mergeToUpdate(List<MatockInfo> baseInfos, List<MatockInfo> selectedInfos) {
		InfoMergerBuilderV3<MatockInfo, MatockInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatockVisiMergeToUpdate());
		InfoMergerV3<MatockInfo, MatockInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
