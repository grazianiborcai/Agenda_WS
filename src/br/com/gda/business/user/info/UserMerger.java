package br.com.gda.business.user.info;

import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.masterData.info.AuthGrRoleInfo;
import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.business.personCustomer.info.PersonCusInfo;
import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.business.userSnapshot.info.UserapInfo;
import br.com.gda.info.InfoMerger;
import br.com.gda.security.username.info.UsernameInfo;

public final class UserMerger {
	public static UserInfo mergeWithAddress(AddressInfo sourceOne, UserInfo sourceTwo) {
		InfoMerger<UserInfo, AddressInfo> merger = new UserMergerAddress();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<UserInfo> mergeWithAddress(List<AddressInfo> sourceOnes, List<UserInfo> sourceTwos) {
		InfoMerger<UserInfo, AddressInfo> merger = new UserMergerAddress();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static UserInfo mergeWithAuthGrRole(AuthGrRoleInfo sourceOne, UserInfo sourceTwo) {
		InfoMerger<UserInfo, AuthGrRoleInfo> merger = new UserMergerAuthGrRole();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<UserInfo> mergeWithAuthGrRole(List<AuthGrRoleInfo> sourceOnes, List<UserInfo> sourceTwos) {
		InfoMerger<UserInfo, AuthGrRoleInfo> merger = new UserMergerAuthGrRole();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static UserInfo mergeWithPerson(PersonInfo sourceOne, UserInfo sourceTwo) {
		InfoMerger<UserInfo, PersonInfo> merger = new UserMergerPerson();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<UserInfo> mergeWithPerson(List<PersonInfo> sourceOnes, List<UserInfo> sourceTwos) {
		InfoMerger<UserInfo, PersonInfo> merger = new UserMergerPerson();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static UserInfo mergeWithPersonCus(PersonCusInfo sourceOne, UserInfo sourceTwo) {
		InfoMerger<UserInfo, PersonCusInfo> merger = new UserMergerPersonCus_();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<UserInfo> mergeWithPersonCus(List<PersonCusInfo> sourceOnes, List<UserInfo> sourceTwos) {
		InfoMerger<UserInfo, PersonCusInfo> merger = new UserMergerPersonCus_();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static UserInfo mergeWithPhone(PhoneInfo sourceOne, UserInfo sourceTwo) {
		InfoMerger<UserInfo, PhoneInfo> merger = new UserMergerPhone();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<UserInfo> mergeWithPhone(List<PhoneInfo> sourceOnes, List<UserInfo> sourceTwos) {
		InfoMerger<UserInfo, PhoneInfo> merger = new UserMergerPhone();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static UserInfo mergeWithUsername(UsernameInfo sourceOne, UserInfo sourceTwo) {
		InfoMerger<UserInfo, UsernameInfo> merger = new UserMergerUsername();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<UserInfo> mergeWithUsername(List<UsernameInfo> sourceOnes, List<UserInfo> sourceTwos) {
		InfoMerger<UserInfo, UsernameInfo> merger = new UserMergerUsername();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static UserInfo mergeWithUserap(UserapInfo sourceOne, UserInfo sourceTwo) {
		InfoMerger<UserInfo, UserapInfo> merger = new UserMergerUserap();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<UserInfo> mergeWithUserap(List<UserapInfo> sourceOnes, List<UserInfo> sourceTwos) {
		InfoMerger<UserInfo, UserapInfo> merger = new UserMergerUserap();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static UserInfo mergeToDelete(UserInfo sourceOne, UserInfo sourceTwo) {
		InfoMerger<UserInfo, UserInfo> merger = new UserMergerToDelete();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<UserInfo> mergeToDelete(List<UserInfo> sourceOnes, List<UserInfo> sourceTwos) {
		InfoMerger<UserInfo, UserInfo> merger = new UserMergerToDelete();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static UserInfo mergeToSelect(UserInfo sourceOne, UserInfo sourceTwo) {
		InfoMerger<UserInfo, UserInfo> merger = new UserMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<UserInfo> mergeToSelect(List<UserInfo> sourceOnes, List<UserInfo> sourceTwos) {
		InfoMerger<UserInfo, UserInfo> merger = new UserMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static UserInfo mergeToUpdate(UserInfo sourceOne, UserInfo sourceTwo) {
		InfoMerger<UserInfo, UserInfo> merger = new UserMergerToUpdate();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<UserInfo> mergeToUpdate(List<UserInfo> sourceOnes, List<UserInfo> sourceTwos) {
		InfoMerger<UserInfo, UserInfo> merger = new UserMergerToUpdate();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
}
