package br.com.mind5.business.person.info;

import java.util.List;

import br.com.mind5.authorization.storePartitionAuthorization.info.SytotauhInfo;
import br.com.mind5.business.personBio.info.PerbioInfo;
import br.com.mind5.business.personSnapshot.info.PersonapInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.masterData.gender.info.GenderInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class PersonMerger {
	public static List<PersonInfo> mergeWithPerbio(List<PersonInfo> baseInfos, List<PerbioInfo> selectedInfos) {
		InfoMergerBuilder<PersonInfo, PerbioInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PersonVisiMergePerbio());
		InfoMerger<PersonInfo, PerbioInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PersonInfo> mergeWithSytotauh(List<PersonInfo> baseInfos, List<SytotauhInfo> selectedInfos) {
		InfoMergerBuilder<PersonInfo, SytotauhInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PersonVisiMergeSytotauh());
		InfoMerger<PersonInfo, SytotauhInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PersonInfo> mergeWithPersonap(List<PersonInfo> baseInfos, List<PersonapInfo> selectedInfos) {
		InfoMergerBuilder<PersonInfo, PersonapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PersonVisiMergePersonap());
		InfoMerger<PersonInfo, PersonapInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PersonInfo> mergeWithGender(List<PersonInfo> baseInfos, List<GenderInfo> selectedInfos) {
		InfoMergerBuilder<PersonInfo, GenderInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PersonVisiMergeGender());
		InfoMerger<PersonInfo, GenderInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PersonInfo> mergeWithUsername(List<PersonInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilder<PersonInfo, UsernameInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PersonVisiMergeUsername());
		InfoMerger<PersonInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PersonInfo> mergeToSelect(List<PersonInfo> baseInfos, List<PersonInfo> selectedInfos) {
		InfoMergerBuilder<PersonInfo, PersonInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PersonVisiMergeToSelect());
		InfoMerger<PersonInfo, PersonInfo> merger = builder.build();		
	
		return merger.merge();
	} 
	
	
	
	public static List<PersonInfo> mergeToUpdate(List<PersonInfo> baseInfos, List<PersonInfo> selectedInfos) {
		InfoMergerBuilder<PersonInfo, PersonInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PersonVisiMergeToUpdate());
		InfoMerger<PersonInfo, PersonInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
