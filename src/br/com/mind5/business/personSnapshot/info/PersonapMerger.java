package br.com.mind5.business.personSnapshot.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.masterData.gender.info.GenderInfo;

public final class PersonapMerger {	
	public static List<PersonapInfo> mergeWithGender(List<PersonapInfo> baseInfos, List<GenderInfo> selectedInfos) {
		InfoMergerBuilderV3<PersonapInfo, GenderInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PersonapVisiMergeGender());
		InfoMergerV3<PersonapInfo, GenderInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PersonapInfo> mergeToSelect(List<PersonapInfo> baseInfos, List<PersonapInfo> selectedInfos) {
		InfoMergerBuilderV3<PersonapInfo, PersonapInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PersonapVisiMergeToSelect());
		InfoMergerV3<PersonapInfo, PersonapInfo> merger = builder.build();		
	
		return merger.merge();
	} 
}
