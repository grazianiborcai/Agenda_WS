package br.com.mind5.business.petList.info;

import java.util.List;

import br.com.mind5.business.pet.info.PetInfo;
import br.com.mind5.business.petSearch.info.PetarchInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;

public final class PetlisMerger {
	public static List<PetlisInfo> mergeWithPet(List<PetlisInfo> baseInfos, List<PetInfo> selectedInfos) {
		InfoMergerBuilder<PetlisInfo, PetInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PetlisVisiMergePet());
		InfoMerger<PetlisInfo, PetInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PetlisInfo> mergeWithPetarch(List<PetlisInfo> baseInfos, List<PetarchInfo> selectedInfos) {
		InfoMergerBuilder<PetlisInfo, PetarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PetlisVisiMergePetarch());
		InfoMerger<PetlisInfo, PetarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
