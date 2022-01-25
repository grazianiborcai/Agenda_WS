package br.com.mind5.business.personBioList.info;

import java.util.List;

import br.com.mind5.business.personBio.info.PerbioInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;

public final class PerbiolisMerger {
	public static List<PerbiolisInfo> mergeWithPerbio(List<PerbiolisInfo> baseInfos, List<PerbioInfo> selectedInfos) {
		InfoMergerBuilder<PerbiolisInfo, PerbioInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PerbiolisVisiMergePet());
		InfoMerger<PerbiolisInfo, PerbioInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
