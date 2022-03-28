package br.com.mind5.business.petList.info;

import java.util.List;

import br.com.mind5.business.pet.info.PetInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;

public final class PetlisMerger {
	public static List<PetlisInfo> mergeWithPet(List<PetlisInfo> baseInfos, List<PetInfo> selectedInfos) {
		InfoMergerBuilder<PetlisInfo, PetInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PetlisMergerVisiPet());
		InfoMerger<PetlisInfo, PetInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PetlisInfo> mergeWithPetSearch(List<PetlisInfo> baseInfos, List<PetInfo> selectedInfos) {
		InfoMergerBuilder<PetlisInfo, PetInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PetlisMergerVisiPetSearch());
		InfoMerger<PetlisInfo, PetInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
