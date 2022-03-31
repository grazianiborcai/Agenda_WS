package br.com.mind5.business.addressSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class AddarchMerger {	
	public static List<AddarchInfo> mergeToSelect(List<AddarchInfo> baseInfos, List<AddarchInfo> selectedInfos) {
		InfoMergerBuilder<AddarchInfo, AddarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new AddarchMergerVisiToSelect());
		InfoMerger<AddarchInfo, AddarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
