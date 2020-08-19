package br.com.mind5.business.materialGroupStore.info;

import java.util.List;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class MatoporeMerger {
	public static List<MatoporeInfo> mergeWithMatore(List<MatoporeInfo> baseInfos, List<MatoreInfo> selectedInfos) {
		InfoMergerBuilderV3<MatoporeInfo, MatoreInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatoporeVisiMergeMatore());
		InfoMergerV3<MatoporeInfo, MatoreInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
