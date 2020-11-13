package br.com.mind5.businessContent.material.main.info;

import java.util.List;

import br.com.mind5.business.ownerList.info.OwnelisInfo;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class MatbcinMerger {
	public static List<MatbcinInfo> mergeWithOwnelis(List<MatbcinInfo> baseInfos, List<OwnelisInfo> selectedInfos) {
		InfoMergerBuilder<MatbcinInfo, OwnelisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatbcinVisiMergeOwnelis());
		InfoMerger<MatbcinInfo, OwnelisInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
