package br.com.mind5.business.materialGroupStore.info;

import java.util.List;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class MatoporeMerger {
	public static List<MatoporeInfo> mergeWithMatore(List<MatoporeInfo> baseInfos, List<MatoreInfo> selectedInfos) {
		InfoMergerBuilder<MatoporeInfo, MatoreInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatoporeVisiMergeMatore());
		InfoMerger<MatoporeInfo, MatoreInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
