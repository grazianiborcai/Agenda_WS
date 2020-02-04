package br.com.mind5.business.employee.info;

import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.employeeSearch.info.EmparchInfo;
import br.com.mind5.business.employeeSnapshot.info.EmpnapInfo;
import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.personSearch.info.PerarchInfo;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.obsolete.InfoMerger_;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class EmpMerger {
	public static EmpInfo mergeWithEmparch(EmparchInfo sourceOne, EmpInfo sourceTwo) {
		InfoMerger_<EmpInfo, EmparchInfo> merger = new EmpMergerEmparch();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmpInfo> mergeWithEmparch(List<EmparchInfo> sourceOnes, List<EmpInfo> sourceTwos) {
		InfoMerger_<EmpInfo, EmparchInfo> merger = new EmpMergerEmparch();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static EmpInfo mergeWithPerarch(PerarchInfo sourceOne, EmpInfo sourceTwo) {
		InfoMerger_<EmpInfo, PerarchInfo> merger = new EmpMergerPerarch();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmpInfo> mergeWithPerarch(List<PerarchInfo> sourceOnes, List<EmpInfo> sourceTwos) {
		InfoMerger_<EmpInfo, PerarchInfo> merger = new EmpMergerPerarch();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static EmpInfo mergeWithFimist(FimistInfo sourceOne, EmpInfo sourceTwo) {
		InfoMerger_<EmpInfo, FimistInfo> merger = new EmpMergerFimist();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmpInfo> mergeWithFimist(List<FimistInfo> sourceOnes, List<EmpInfo> sourceTwos) {
		InfoMerger_<EmpInfo, FimistInfo> merger = new EmpMergerFimist();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static EmpInfo mergeWithAddress(AddressInfo sourceOne, EmpInfo sourceTwo) {
		InfoMerger_<EmpInfo, AddressInfo> merger = new EmpMergerAddress();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmpInfo> mergeWithAddress(List<AddressInfo> sourceOnes, List<EmpInfo> sourceTwos) {
		InfoMerger_<EmpInfo, AddressInfo> merger = new EmpMergerAddress();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static EmpInfo mergeWithEmpnap(EmpnapInfo sourceOne, EmpInfo sourceTwo) {
		InfoMerger_<EmpInfo, EmpnapInfo> merger = new EmpMergerEmpnap();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmpInfo> mergeWithEmpnap(List<EmpnapInfo> sourceOnes, List<EmpInfo> sourceTwos) {
		InfoMerger_<EmpInfo, EmpnapInfo> merger = new EmpMergerEmpnap();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static EmpInfo mergeWithPerson(PersonInfo sourceOne, EmpInfo sourceTwo) {
		InfoMerger_<EmpInfo, PersonInfo> merger = new EmpMergerPerson();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmpInfo> mergeWithPerson(List<PersonInfo> sourceOnes, List<EmpInfo> sourceTwos) {
		InfoMerger_<EmpInfo, PersonInfo> merger = new EmpMergerPerson();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static EmpInfo mergeWithPhone(PhoneInfo sourceOne, EmpInfo sourceTwo) {
		InfoMerger_<EmpInfo, PhoneInfo> merger = new EmpMergerPhone();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmpInfo> mergeWithPhone(List<PhoneInfo> sourceOnes, List<EmpInfo> sourceTwos) {
		InfoMerger_<EmpInfo, PhoneInfo> merger = new EmpMergerPhone();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static EmpInfo mergeWithUser(UserInfo sourceOne, EmpInfo sourceTwo) {
		InfoMerger_<EmpInfo, UserInfo> merger = new EmpMergerUser();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmpInfo> mergeWithUser(List<UserInfo> sourceOnes, List<EmpInfo> sourceTwos) {
		InfoMerger_<EmpInfo, UserInfo> merger = new EmpMergerUser();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static EmpInfo mergeWithUsername(UsernameInfo sourceOne, EmpInfo sourceTwo) {
		InfoMerger_<EmpInfo, UsernameInfo> merger = new EmpMergerUsername();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmpInfo> mergeWithUsername(List<UsernameInfo> sourceOnes, List<EmpInfo> sourceTwos) {
		InfoMerger_<EmpInfo, UsernameInfo> merger = new EmpMergerUsername();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static EmpInfo mergeToDelete(EmpInfo sourceOne, EmpInfo sourceTwo) {
		InfoMerger_<EmpInfo, EmpInfo> merger = new EmpMergerToDelete();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmpInfo> mergeToDelete(List<EmpInfo> sourceOnes, List<EmpInfo> sourceTwos) {
		InfoMerger_<EmpInfo, EmpInfo> merger = new EmpMergerToDelete();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static EmpInfo mergeToSelect(EmpInfo sourceOne, EmpInfo sourceTwo) {
		InfoMerger_<EmpInfo, EmpInfo> merger = new EmpMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmpInfo> mergeToSelect(List<EmpInfo> sourceOnes, List<EmpInfo> sourceTwos) {
		InfoMerger_<EmpInfo, EmpInfo> merger = new EmpMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static EmpInfo mergeToUpdate(EmpInfo sourceOne, EmpInfo sourceTwo) {
		InfoMerger_<EmpInfo, EmpInfo> merger = new EmpMergerToUpdate();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmpInfo> mergeToUpdate(List<EmpInfo> sourceOnes, List<EmpInfo> sourceTwos) {
		InfoMerger_<EmpInfo, EmpInfo> merger = new EmpMergerToUpdate();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
