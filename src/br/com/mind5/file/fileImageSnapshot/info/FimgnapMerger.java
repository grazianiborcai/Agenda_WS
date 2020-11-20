package br.com.mind5.file.fileImageSnapshot.info;

import java.util.List;

import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;

public final class FimgnapMerger {	
	public static List<FimgnapInfo> mergeToSelect(List<FimgnapInfo> baseInfos, List<FimgnapInfo> selectedInfos) {
		InfoMergerBuilder<FimgnapInfo, FimgnapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new FimgnapVisiMergeToSelect());
		InfoMerger<FimgnapInfo, FimgnapInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
