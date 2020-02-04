package br.com.mind5.security.user.info;

import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.masterData.info.AuthGrRoleInfo;
import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.obsolete.InfoMerger_;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.security.userSearch.info.UserarchInfo;
import br.com.mind5.security.userSnapshot.info.UserapInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class UserMerger {
	public static UserInfo mergeWithFimist(FimistInfo sourceOne, UserInfo sourceTwo) {
		InfoMerger_<UserInfo, FimistInfo> merger = new UserMergerFimist();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<UserInfo> mergeWithFimist(List<FimistInfo> sourceOnes, List<UserInfo> sourceTwos) {
		InfoMerger_<UserInfo, FimistInfo> merger = new UserMergerFimist();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static UserInfo mergeWithUserarch(UserarchInfo sourceOne, UserInfo sourceTwo) {
		InfoMerger_<UserInfo, UserarchInfo> merger = new UserMergerUserarch();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<UserInfo> mergeWithUserarch(List<UserarchInfo> sourceOnes, List<UserInfo> sourceTwos) {
		InfoMerger_<UserInfo, UserarchInfo> merger = new UserMergerUserarch();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static UserInfo mergeWithAddress(AddressInfo sourceOne, UserInfo sourceTwo) {
		InfoMerger_<UserInfo, AddressInfo> merger = new UserMergerAddress();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<UserInfo> mergeWithAddress(List<AddressInfo> sourceOnes, List<UserInfo> sourceTwos) {
		InfoMerger_<UserInfo, AddressInfo> merger = new UserMergerAddress();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static UserInfo mergeWithCuspar(CusparInfo sourceOne, UserInfo sourceTwo) {
		InfoMerger_<UserInfo, CusparInfo> merger = new UserMergerCuspar();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<UserInfo> mergeWithCuspar(List<CusparInfo> sourceOnes, List<UserInfo> sourceTwos) {
		InfoMerger_<UserInfo, CusparInfo> merger = new UserMergerCuspar();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static UserInfo mergeWithAuthGrRole(AuthGrRoleInfo sourceOne, UserInfo sourceTwo) {
		InfoMerger_<UserInfo, AuthGrRoleInfo> merger = new UserMergerAuthGrRole();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<UserInfo> mergeWithAuthGrRole(List<AuthGrRoleInfo> sourceOnes, List<UserInfo> sourceTwos) {
		InfoMerger_<UserInfo, AuthGrRoleInfo> merger = new UserMergerAuthGrRole();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static UserInfo mergeWithPerson(PersonInfo sourceOne, UserInfo sourceTwo) {
		InfoMerger_<UserInfo, PersonInfo> merger = new UserMergerPerson();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<UserInfo> mergeWithPerson(List<PersonInfo> sourceOnes, List<UserInfo> sourceTwos) {
		InfoMerger_<UserInfo, PersonInfo> merger = new UserMergerPerson();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static UserInfo mergeWithPhone(PhoneInfo sourceOne, UserInfo sourceTwo) {
		InfoMerger_<UserInfo, PhoneInfo> merger = new UserMergerPhone();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<UserInfo> mergeWithPhone(List<PhoneInfo> sourceOnes, List<UserInfo> sourceTwos) {
		InfoMerger_<UserInfo, PhoneInfo> merger = new UserMergerPhone();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static UserInfo mergeWithUsername(UsernameInfo sourceOne, UserInfo sourceTwo) {
		InfoMerger_<UserInfo, UsernameInfo> merger = new UserMergerUsername();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<UserInfo> mergeWithUsername(List<UsernameInfo> sourceOnes, List<UserInfo> sourceTwos) {
		InfoMerger_<UserInfo, UsernameInfo> merger = new UserMergerUsername();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static UserInfo mergeWithUserap(UserapInfo sourceOne, UserInfo sourceTwo) {
		InfoMerger_<UserInfo, UserapInfo> merger = new UserMergerUserap();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<UserInfo> mergeWithUserap(List<UserapInfo> sourceOnes, List<UserInfo> sourceTwos) {
		InfoMerger_<UserInfo, UserapInfo> merger = new UserMergerUserap();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static UserInfo mergeToDelete(UserInfo sourceOne, UserInfo sourceTwo) {
		InfoMerger_<UserInfo, UserInfo> merger = new UserMergerToDelete();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<UserInfo> mergeToDelete(List<UserInfo> sourceOnes, List<UserInfo> sourceTwos) {
		InfoMerger_<UserInfo, UserInfo> merger = new UserMergerToDelete();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static UserInfo mergeToSelect(UserInfo sourceOne, UserInfo sourceTwo) {
		InfoMerger_<UserInfo, UserInfo> merger = new UserMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<UserInfo> mergeToSelect(List<UserInfo> sourceOnes, List<UserInfo> sourceTwos) {
		InfoMerger_<UserInfo, UserInfo> merger = new UserMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static UserInfo mergeToUpdate(UserInfo sourceOne, UserInfo sourceTwo) {
		InfoMerger_<UserInfo, UserInfo> merger = new UserMergerToUpdate();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<UserInfo> mergeToUpdate(List<UserInfo> sourceOnes, List<UserInfo> sourceTwos) {
		InfoMerger_<UserInfo, UserInfo> merger = new UserMergerToUpdate();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
}
