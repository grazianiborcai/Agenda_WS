package br.com.mind5.business.scheduleLineSnapshot.info;

import java.util.List;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.business.employeeRestricted.info.EmplresInfo;
import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.petList.info.PetlisInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.security.userList.info.UselisInfo;

public final class SchedinapMerger {
	public static List<SchedinapInfo> mergeWithPetlis(List<SchedinapInfo> baseInfos, List<PetlisInfo> selectedInfos) {
		InfoMergerBuilder<SchedinapInfo, PetlisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedinapVisiMergePetlis());
		InfoMerger<SchedinapInfo, PetlisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedinapInfo> mergeWithUselis(List<SchedinapInfo> baseInfos, List<UselisInfo> selectedInfos) {
		InfoMergerBuilder<SchedinapInfo, UselisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedinapVisiMergeUselis());
		InfoMerger<SchedinapInfo, UselisInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<SchedinapInfo> mergeWithCuslis(List<SchedinapInfo> baseInfos, List<CuslisInfo> selectedInfos) {
		InfoMergerBuilder<SchedinapInfo, CuslisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedinapVisiMergeCuslis());
		InfoMerger<SchedinapInfo, CuslisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedinapInfo> mergeWithEmplres(List<SchedinapInfo> baseInfos, List<EmplresInfo> selectedInfos) {
		InfoMergerBuilder<SchedinapInfo, EmplresInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedinapVisiMergeEmplres());
		InfoMerger<SchedinapInfo, EmplresInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedinapInfo> mergeWithStolis(List<SchedinapInfo> baseInfos, List<StolisInfo> selectedInfos) {
		InfoMergerBuilder<SchedinapInfo, StolisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedinapVisiMergeStolis());
		InfoMerger<SchedinapInfo, StolisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedinapInfo> mergeWithMatlis(List<SchedinapInfo> baseInfos, List<MatlisInfo> selectedInfos) {
		InfoMergerBuilder<SchedinapInfo, MatlisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedinapVisiMergeMatlis());
		InfoMerger<SchedinapInfo, MatlisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedinapInfo> mergeToSelect(List<SchedinapInfo> baseInfos, List<SchedinapInfo> selectedInfos) {
		InfoMergerBuilder<SchedinapInfo, SchedinapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedinapVisiMergeToSelect());
		InfoMerger<SchedinapInfo, SchedinapInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
