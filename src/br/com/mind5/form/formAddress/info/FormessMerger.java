package br.com.mind5.form.formAddress.info;

import java.util.List;

import br.com.mind5.business.form.formAddressSearch.info.FormesarchInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class FormessMerger {
	public static List<FormessInfo> mergeWithFormesarch(List<FormessInfo> baseInfos, List<FormesarchInfo> selectedInfos) {
		InfoMergerBuilderV3<FormessInfo, FormesarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new FormessVisiMergeFormesarch());
		InfoMergerV3<FormessInfo, FormesarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<FormessInfo> mergeToSelect(List<FormessInfo> baseInfos, List<FormessInfo> selectedInfos) {
		InfoMergerBuilderV3<FormessInfo, FormessInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new FormessVisiMergeToSelect());
		InfoMergerV3<FormessInfo, FormessInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
