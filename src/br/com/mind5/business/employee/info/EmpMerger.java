package br.com.mind5.business.employee.info;

import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.employeeSnapshot.info.EmpnapInfo;
import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class EmpMerger {
	public static EmpInfo mergeWithAddress(AddressInfo sourceOne, EmpInfo sourceTwo) {
		InfoMerger<EmpInfo, AddressInfo> merger = new EmpMergerAddress();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmpInfo> mergeWithAddress(List<AddressInfo> sourceOnes, List<EmpInfo> sourceTwos) {
		InfoMerger<EmpInfo, AddressInfo> merger = new EmpMergerAddress();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static EmpInfo mergeWithEmpnap(EmpnapInfo sourceOne, EmpInfo sourceTwo) {
		InfoMerger<EmpInfo, EmpnapInfo> merger = new EmpMergerEmpnap();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmpInfo> mergeWithEmpnap(List<EmpnapInfo> sourceOnes, List<EmpInfo> sourceTwos) {
		InfoMerger<EmpInfo, EmpnapInfo> merger = new EmpMergerEmpnap();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static EmpInfo mergeWithPerson(PersonInfo sourceOne, EmpInfo sourceTwo) {
		InfoMerger<EmpInfo, PersonInfo> merger = new EmpMergerPerson();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmpInfo> mergeWithPerson(List<PersonInfo> sourceOnes, List<EmpInfo> sourceTwos) {
		InfoMerger<EmpInfo, PersonInfo> merger = new EmpMergerPerson();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static EmpInfo mergeWithPhone(PhoneInfo sourceOne, EmpInfo sourceTwo) {
		InfoMerger<EmpInfo, PhoneInfo> merger = new EmpMergerPhone();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmpInfo> mergeWithPhone(List<PhoneInfo> sourceOnes, List<EmpInfo> sourceTwos) {
		InfoMerger<EmpInfo, PhoneInfo> merger = new EmpMergerPhone();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static EmpInfo mergeWithUser(UserInfo sourceOne, EmpInfo sourceTwo) {
		InfoMerger<EmpInfo, UserInfo> merger = new EmpMergerUser();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmpInfo> mergeWithUser(List<UserInfo> sourceOnes, List<EmpInfo> sourceTwos) {
		InfoMerger<EmpInfo, UserInfo> merger = new EmpMergerUser();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static EmpInfo mergeWithUsername(UsernameInfo sourceOne, EmpInfo sourceTwo) {
		InfoMerger<EmpInfo, UsernameInfo> merger = new EmpMergerUsername();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmpInfo> mergeWithUsername(List<UsernameInfo> sourceOnes, List<EmpInfo> sourceTwos) {
		InfoMerger<EmpInfo, UsernameInfo> merger = new EmpMergerUsername();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static EmpInfo mergeToDelete(EmpInfo sourceOne, EmpInfo sourceTwo) {
		InfoMerger<EmpInfo, EmpInfo> merger = new EmpMergerToDelete();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmpInfo> mergeToDelete(List<EmpInfo> sourceOnes, List<EmpInfo> sourceTwos) {
		InfoMerger<EmpInfo, EmpInfo> merger = new EmpMergerToDelete();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static EmpInfo mergeToSelect(EmpInfo sourceOne, EmpInfo sourceTwo) {
		InfoMerger<EmpInfo, EmpInfo> merger = new EmpMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmpInfo> mergeToSelect(List<EmpInfo> sourceOnes, List<EmpInfo> sourceTwos) {
		InfoMerger<EmpInfo, EmpInfo> merger = new EmpMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
