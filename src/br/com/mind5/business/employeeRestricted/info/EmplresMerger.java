package br.com.mind5.business.employeeRestricted.info;

import java.util.List;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;

public final class EmplresMerger {
	public static List<EmplresInfo> mergeWithEmplis(List<EmplresInfo> baseInfos, List<EmplisInfo> selectedInfos) {
		InfoMergerBuilder<EmplresInfo, EmplisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmplresMergerVisiEmplis());
		InfoMerger<EmplresInfo, EmplisInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
