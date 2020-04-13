package br.com.mind5.form.formPhone.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class FormoneMerger {
	
	public static List<FormoneInfo> mergeToSelect(List<FormoneInfo> baseInfos, List<FormoneInfo> selectedInfos) {
		InfoMergerBuilderV3<FormoneInfo, FormoneInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new FormoneVisiMergeToSelect());
		InfoMergerV3<FormoneInfo, FormoneInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
