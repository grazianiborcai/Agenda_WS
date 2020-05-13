package br.com.mind5.business.orderItemList.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class OrdemistMerger {
	public static List<OrdemistInfo> mergeToSelect(List<OrdemistInfo> baseInfos, List<OrdemistInfo> selectedInfos) {
		InfoMergerBuilderV3<OrdemistInfo, OrdemistInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdemistVisiMergeToSelect());
		InfoMergerV3<OrdemistInfo, OrdemistInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
