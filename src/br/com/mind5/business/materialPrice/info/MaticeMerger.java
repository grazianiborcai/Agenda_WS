package br.com.mind5.business.materialPrice.info;

import java.util.List;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;

public final class MaticeMerger {
	public static List<MaticeInfo> mergeWithMatore(List<MaticeInfo> baseInfos, List<MatoreInfo> selectedInfos) {
		InfoMergerBuilder<MaticeInfo, MatoreInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MaticeMergerVisiMatore());
		InfoMerger<MaticeInfo, MatoreInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
