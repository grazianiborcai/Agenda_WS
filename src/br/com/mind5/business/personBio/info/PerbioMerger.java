package br.com.mind5.business.personBio.info;

import java.util.List;

import br.com.mind5.business.petSearch.info.PetarchInfo;
import br.com.mind5.business.petSnapshot.info.PetsnapInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.security.username.info.UsernameInfo;

public final class PerbioMerger {
	public static List<PerbioInfo> mergeWithUsername(List<PerbioInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilder<PerbioInfo, UsernameInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PetVisiMergeUsername());
		InfoMerger<PerbioInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PerbioInfo> mergeWithPetarch(List<PerbioInfo> baseInfos, List<PetarchInfo> selectedInfos) {
		InfoMergerBuilder<PerbioInfo, PetarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PetVisiMergePetarch());
		InfoMerger<PerbioInfo, PetarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PerbioInfo> mergeWithPetsnap(List<PerbioInfo> baseInfos, List<PetsnapInfo> selectedInfos) {
		InfoMergerBuilder<PerbioInfo, PetsnapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PetVisiMergePetsnap());
		InfoMerger<PerbioInfo, PetsnapInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PerbioInfo> mergeToSelect(List<PerbioInfo> baseInfos, List<PerbioInfo> selectedInfos) {
		InfoMergerBuilder<PerbioInfo, PerbioInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PerbioVisiMergeToSelect());
		InfoMerger<PerbioInfo, PerbioInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PerbioInfo> mergeToUpdate(List<PerbioInfo> baseInfos, List<PerbioInfo> selectedInfos) {
		InfoMergerBuilder<PerbioInfo, PerbioInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PerbioVisiMergeToUpdate());
		InfoMerger<PerbioInfo, PerbioInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
