package br.com.mind5.form.formAddress.info;

import java.util.List;

import br.com.mind5.form.formAddressSearch.info.FormesarchInfo;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class FormessMerger {
	public static List<FormessInfo> mergeWithFormesarch(List<FormessInfo> baseInfos, List<FormesarchInfo> selectedInfos) {
		InfoMergerBuilder<FormessInfo, FormesarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new FormessVisiMergeFormesarch());
		InfoMerger<FormessInfo, FormesarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<FormessInfo> mergeToSelect(List<FormessInfo> baseInfos, List<FormessInfo> selectedInfos) {
		InfoMergerBuilder<FormessInfo, FormessInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new FormessVisiMergeToSelect());
		InfoMerger<FormessInfo, FormessInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
