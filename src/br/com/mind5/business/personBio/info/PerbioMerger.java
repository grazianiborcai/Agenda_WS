package br.com.mind5.business.personBio.info;

import java.util.List;

import br.com.mind5.business.personBioSnapshot.info.PerbionapInfo;
import br.com.mind5.business.petSearch.info.PetarchInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.security.username.info.UsernameInfo;

public final class PerbioMerger {
	public static List<PerbioInfo> mergeWithUsername(List<PerbioInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilder<PerbioInfo, UsernameInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PerbioVisiMergeUsername());
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
	
	
	
	public static List<PerbioInfo> mergeWithPerbionap(List<PerbioInfo> baseInfos, List<PerbionapInfo> selectedInfos) {
		InfoMergerBuilder<PerbioInfo, PerbionapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PerbioVisiMergePerbionap());
		InfoMerger<PerbioInfo, PerbionapInfo> merger = builder.build();		
	
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
