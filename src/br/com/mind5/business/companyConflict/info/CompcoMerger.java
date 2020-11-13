package br.com.mind5.business.companyConflict.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class CompcoMerger {	
	public static List<CompcoInfo> mergeToSelect(List<CompcoInfo> baseInfos, List<CompcoInfo> selectedInfos) {
		InfoMergerBuilder<CompcoInfo, CompcoInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CompcoVisiMergeToSelect());
		InfoMerger<CompcoInfo, CompcoInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
