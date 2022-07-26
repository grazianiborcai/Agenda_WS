package br.com.mind5.form.formPhone.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class FormoneMerger {
	
	public static List<FormoneInfo> mergeToSelect(List<FormoneInfo> baseInfos, List<FormoneInfo> selectedInfos) {
		InfoMergerBuilder<FormoneInfo, FormoneInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new FormoneMergerVisiToSelect());
		InfoMerger<FormoneInfo, FormoneInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
