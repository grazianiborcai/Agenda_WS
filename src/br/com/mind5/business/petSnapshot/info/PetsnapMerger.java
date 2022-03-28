package br.com.mind5.business.petSnapshot.info;

import java.util.List;

import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.masterData.petType.info.PetypeInfo;
import br.com.mind5.masterData.petWeight.info.PeteightInfo;

public final class PetsnapMerger {
	public static List<PetsnapInfo> mergeWithPetype(List<PetsnapInfo> baseInfos, List<PetypeInfo> selectedInfos) {
		InfoMergerBuilder<PetsnapInfo, PetypeInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PetsnapMergerVisiPetype());
		InfoMerger<PetsnapInfo, PetypeInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PetsnapInfo> mergeWithPeteight(List<PetsnapInfo> baseInfos, List<PeteightInfo> selectedInfos) {
		InfoMergerBuilder<PetsnapInfo, PeteightInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PetsnapMergerVisiPeteight());
		InfoMerger<PetsnapInfo, PeteightInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<PetsnapInfo> mergeToSelect(List<PetsnapInfo> baseInfos, List<PetsnapInfo> selectedInfos) {
		InfoMergerBuilder<PetsnapInfo, PetsnapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PetsnapMergerVisiToSelect());
		InfoMerger<PetsnapInfo, PetsnapInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
