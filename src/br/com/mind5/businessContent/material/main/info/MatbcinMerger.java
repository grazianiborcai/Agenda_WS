package br.com.mind5.businessContent.material.main.info;

import java.util.List;

import br.com.mind5.business.ownerList.info.OwnelisInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class MatbcinMerger {
	public static List<MatbcinInfo> mergeWithOwnelis(List<MatbcinInfo> baseInfos, List<OwnelisInfo> selectedInfos) {
		InfoMergerBuilderV3<MatbcinInfo, OwnelisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatbcinVisiMergeOwnelis());
		InfoMergerV3<MatbcinInfo, OwnelisInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
