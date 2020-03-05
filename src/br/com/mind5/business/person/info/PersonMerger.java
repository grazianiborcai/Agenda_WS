package br.com.mind5.business.person.info;

import java.util.List;

import br.com.mind5.business.masterData.info.GenderInfo;
import br.com.mind5.business.personSnapshot.info.PersonapInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.security.username.info.UsernameInfo;

public final class PersonMerger {
	public static List<PersonInfo> mergeWithPersonap(List<PersonInfo> baseInfos, List<PersonapInfo> selectedInfos) {
		InfoMergerBuilderV3<PersonInfo, PersonapInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PersonVisiMergePersonap());
		InfoMergerV3<PersonInfo, PersonapInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PersonInfo> mergeWithGender(List<PersonInfo> baseInfos, List<GenderInfo> selectedInfos) {
		InfoMergerBuilderV3<PersonInfo, GenderInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PersonVisiMergeGender());
		InfoMergerV3<PersonInfo, GenderInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PersonInfo> mergeWithUsername(List<PersonInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilderV3<PersonInfo, UsernameInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PersonVisiMergeUsername());
		InfoMergerV3<PersonInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PersonInfo> mergeToDelete(List<PersonInfo> baseInfos, List<PersonInfo> selectedInfos) {
		InfoMergerBuilderV3<PersonInfo, PersonInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PersonVisiMergeToDelete());
		InfoMergerV3<PersonInfo, PersonInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PersonInfo> mergeToSelect(List<PersonInfo> baseInfos, List<PersonInfo> selectedInfos) {
		InfoMergerBuilderV3<PersonInfo, PersonInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PersonVisiMergeToSelect());
		InfoMergerV3<PersonInfo, PersonInfo> merger = builder.build();		
	
		return merger.merge();
	} 
	
	
	
	public static List<PersonInfo> mergeToUpdate(List<PersonInfo> baseInfos, List<PersonInfo> selectedInfos) {
		InfoMergerBuilderV3<PersonInfo, PersonInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PersonVisiMergeToUpdate());
		InfoMergerV3<PersonInfo, PersonInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
