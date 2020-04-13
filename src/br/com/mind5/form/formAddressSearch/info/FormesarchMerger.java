package br.com.mind5.form.formAddressSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class FormesarchMerger {
	public static List<FormesarchInfo> mergeToSelect(List<FormesarchInfo> baseInfos, List<FormesarchInfo> selectedInfos) {
		InfoMergerBuilderV3<FormesarchInfo, FormesarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new FormesarchVisiMergeToSelect());
		InfoMergerV3<FormesarchInfo, FormesarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
