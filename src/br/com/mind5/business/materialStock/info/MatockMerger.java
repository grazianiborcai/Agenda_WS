package br.com.mind5.business.materialStock.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class MatockMerger {
	public static List<MatockInfo> mergeToSelect(List<MatockInfo> baseInfos, List<MatockInfo> selectedInfos) {
		InfoMergerBuilder<MatockInfo, MatockInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatockMergerVisiToSelect());
		InfoMerger<MatockInfo, MatockInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatockInfo> mergeToUpdate(List<MatockInfo> baseInfos, List<MatockInfo> selectedInfos) {
		InfoMergerBuilder<MatockInfo, MatockInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatockMergerVisiToUpdate());
		InfoMerger<MatockInfo, MatockInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
