package br.com.mind5.business.addressSnapshotSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;

public final class AddresnaparchMerger {
	public static List<AddresnaparchInfo> mergeToSelect(List<AddresnaparchInfo> baseInfos, List<AddresnaparchInfo> selectedInfos) {
		InfoMergerBuilder<AddresnaparchInfo, AddresnaparchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new AddresnaparchVisiMergeToSelect());
		InfoMerger<AddresnaparchInfo, AddresnaparchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
