package br.com.mind5.business.personSnapshot.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.masterData.gender.info.GenderInfo;

public final class PersonapMerger {	
	public static List<PersonapInfo> mergeWithGender(List<PersonapInfo> baseInfos, List<GenderInfo> selectedInfos) {
		InfoMergerBuilder<PersonapInfo, GenderInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PersonapVisiMergeGender());
		InfoMerger<PersonapInfo, GenderInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PersonapInfo> mergeToSelect(List<PersonapInfo> baseInfos, List<PersonapInfo> selectedInfos) {
		InfoMergerBuilder<PersonapInfo, PersonapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PersonapVisiMergeToSelect());
		InfoMerger<PersonapInfo, PersonapInfo> merger = builder.build();		
	
		return merger.merge();
	} 
}
