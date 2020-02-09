package br.com.mind5.business.addressSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class AddarchMerger {	
	public static List<AddarchInfo> mergeToSelect(List<AddarchInfo> baseInfos, List<AddarchInfo> selectedInfos) {
		InfoMergerBuilderV3<AddarchInfo, AddarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new AddarchVisiMergeToSelect());
		InfoMergerV3<AddarchInfo, AddarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
