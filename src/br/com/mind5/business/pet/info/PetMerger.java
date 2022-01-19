package br.com.mind5.business.pet.info;

import java.util.List;

import br.com.mind5.business.petSnapshot.info.PetsnapInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.masterData.petType.info.PetypeInfo;
import br.com.mind5.masterData.petWeight.info.PeteightInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class PetMerger {
	public static List<PetInfo> mergeWithUsername(List<PetInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilder<PetInfo, UsernameInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PetVisiMergeUsername());
		InfoMerger<PetInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PetInfo> mergeWithPetype(List<PetInfo> baseInfos, List<PetypeInfo> selectedInfos) {
		InfoMergerBuilder<PetInfo, PetypeInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PetVisiMergePetype());
		InfoMerger<PetInfo, PetypeInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PetInfo> mergeWithPeteight(List<PetInfo> baseInfos, List<PeteightInfo> selectedInfos) {
		InfoMergerBuilder<PetInfo, PeteightInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PetVisiMergePeteight());
		InfoMerger<PetInfo, PeteightInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PetInfo> mergeWithPetsnap(List<PetInfo> baseInfos, List<PetsnapInfo> selectedInfos) {
		InfoMergerBuilder<PetInfo, PetsnapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PetVisiMergePetsnap());
		InfoMerger<PetInfo, PetsnapInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PetInfo> mergeToSelect(List<PetInfo> baseInfos, List<PetInfo> selectedInfos) {
		InfoMergerBuilder<PetInfo, PetInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PetVisiMergeToSelect());
		InfoMerger<PetInfo, PetInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PetInfo> mergeToUpdate(List<PetInfo> baseInfos, List<PetInfo> selectedInfos) {
		InfoMergerBuilder<PetInfo, PetInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PetVisiMergeToUpdate());
		InfoMerger<PetInfo, PetInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
