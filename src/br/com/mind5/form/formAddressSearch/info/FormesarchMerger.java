package br.com.mind5.form.formAddressSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class FormesarchMerger {
	public static List<FormesarchInfo> mergeToSelect(List<FormesarchInfo> baseInfos, List<FormesarchInfo> selectedInfos) {
		InfoMergerBuilder<FormesarchInfo, FormesarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new FormesarchVisiMergeToSelect());
		InfoMerger<FormesarchInfo, FormesarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
