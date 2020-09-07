package br.com.mind5.business.addressDefault.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class AddaultMerger {	
	public static List<AddaultInfo> mergeToSelect(List<AddaultInfo> baseInfos, List<AddaultInfo> selectedInfos) {
		InfoMergerBuilderV3<AddaultInfo, AddaultInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new AddaultVisiMergeToSelect());
		InfoMergerV3<AddaultInfo, AddaultInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
