package br.com.mind5.business.companyConflict.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class CompcoMerger {	
	public static List<CompcoInfo> mergeToSelect(List<CompcoInfo> baseInfos, List<CompcoInfo> selectedInfos) {
		InfoMergerBuilderV3<CompcoInfo, CompcoInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CompcoVisiMergeToSelect());
		InfoMergerV3<CompcoInfo, CompcoInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
