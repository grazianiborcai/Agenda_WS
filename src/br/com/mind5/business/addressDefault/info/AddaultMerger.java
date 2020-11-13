package br.com.mind5.business.addressDefault.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class AddaultMerger {	
	public static List<AddaultInfo> mergeToSelect(List<AddaultInfo> baseInfos, List<AddaultInfo> selectedInfos) {
		InfoMergerBuilder<AddaultInfo, AddaultInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new AddaultVisiMergeToSelect());
		InfoMerger<AddaultInfo, AddaultInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
