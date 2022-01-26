package br.com.mind5.business.pet.info;

import java.util.List;

import br.com.mind5.authorization.storePartitionAuthorization.info.SytotauhInfo;
import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.business.petDefault.info.PetaultInfo;
import br.com.mind5.business.petSearch.info.PetarchInfo;
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
	
	
	
	public static List<PetInfo> mergeWithCusarch(List<PetInfo> baseInfos, List<CusarchInfo> selectedInfos) {
		InfoMergerBuilder<PetInfo, CusarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PetVisiMergeCusarch());
		InfoMerger<PetInfo, CusarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	public static List<PetInfo> mergeWithSytotauh(List<PetInfo> baseInfos, List<SytotauhInfo> selectedInfos) {
		InfoMergerBuilder<PetInfo, SytotauhInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PetVisiMergeSytotauh());
		InfoMerger<PetInfo, SytotauhInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	public static List<PetInfo> mergeWithPetarch(List<PetInfo> baseInfos, List<PetarchInfo> selectedInfos) {
		InfoMergerBuilder<PetInfo, PetarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PetVisiMergePetarch());
		InfoMerger<PetInfo, PetarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	public static List<PetInfo> mergeWithPetault(List<PetInfo> baseInfos, List<PetaultInfo> selectedInfos) {
		InfoMergerBuilder<PetInfo, PetaultInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PetVisiMergePetault());
		InfoMerger<PetInfo, PetaultInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	public static List<PetInfo> mergeWithCuslis(List<PetInfo> baseInfos, List<CuslisInfo> selectedInfos) {
		InfoMergerBuilder<PetInfo, CuslisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PetVisiMergeCuslis());
		InfoMerger<PetInfo, CuslisInfo> merger = builder.build();		
	
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
	
	
	
	public static List<PetInfo> mergeToSelectAuth(List<PetInfo> baseInfos, List<PetInfo> selectedInfos) {
		InfoMergerBuilder<PetInfo, PetInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PetVisiMergeToSelectAuth());
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
