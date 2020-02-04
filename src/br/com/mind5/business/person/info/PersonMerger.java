package br.com.mind5.business.person.info;

import java.util.List;

import br.com.mind5.business.masterData.info.GenderInfo;
import br.com.mind5.business.personSnapshot.info.PersonapInfo;
import br.com.mind5.info.obsolete.InfoMerger_;
import br.com.mind5.security.username.info.UsernameInfo;

public final class PersonMerger {
	public static PersonInfo mergeWithPersonap(PersonapInfo sourceOne, PersonInfo sourceTwo) {
		InfoMerger_<PersonInfo, PersonapInfo> merger = new PersonMergerPersonap();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PersonInfo> mergeWithPersonap(List<PersonapInfo> sourceOnes, List<PersonInfo> sourceTwos) {
		InfoMerger_<PersonInfo, PersonapInfo> merger = new PersonMergerPersonap();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static PersonInfo mergeWithGender(GenderInfo sourceOne, PersonInfo sourceTwo) {
		InfoMerger_<PersonInfo, GenderInfo> merger = new PersonMergerGender();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PersonInfo> mergeWithGender(List<GenderInfo> sourceOnes, List<PersonInfo> sourceTwos) {
		InfoMerger_<PersonInfo, GenderInfo> merger = new PersonMergerGender();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static PersonInfo mergeWithUsername(UsernameInfo sourceOne, PersonInfo sourceTwo) {
		InfoMerger_<PersonInfo, UsernameInfo> merger = new PersonMergerUsername();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PersonInfo> mergeWithUsername(List<UsernameInfo> sourceOnes, List<PersonInfo> sourceTwos) {
		InfoMerger_<PersonInfo, UsernameInfo> merger = new PersonMergerUsername();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static PersonInfo mergeToDelete(PersonInfo sourceOne, PersonInfo sourceTwo) {
		InfoMerger_<PersonInfo, PersonInfo> merger = new PersonMergerToDelete();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PersonInfo> mergeToDelete(List<PersonInfo> sourceOnes, List<PersonInfo> sourceTwos) {
		InfoMerger_<PersonInfo, PersonInfo> merger = new PersonMergerToDelete();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static PersonInfo mergeToSelect(PersonInfo sourceOne, PersonInfo sourceTwo) {
		InfoMerger_<PersonInfo, PersonInfo> merger = new PersonMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PersonInfo> mergeToSelect(List<PersonInfo> sourceOnes, List<PersonInfo> sourceTwos) {
		InfoMerger_<PersonInfo, PersonInfo> merger = new PersonMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static PersonInfo mergeToUpdate(PersonInfo sourceOne, PersonInfo sourceTwo) {
		InfoMerger_<PersonInfo, PersonInfo> merger = new PersonMergerToUpdate();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PersonInfo> mergeToUpdate(List<PersonInfo> sourceOnes, List<PersonInfo> sourceTwos) {
		InfoMerger_<PersonInfo, PersonInfo> merger = new PersonMergerToUpdate();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
}
