package br.com.mind5.security.user.info;

import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.masterData.authorizationGroupRole.info.AuthgroleInfo;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.security.userSearch.info.UserarchInfo;
import br.com.mind5.security.userSnapshot.info.UserapInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class UserMerger {
	public static List<UserInfo> mergeWithFimist(List<UserInfo> baseInfos, List<FimistInfo> selectedInfos) {
		InfoMergerBuilderV3<UserInfo, FimistInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new UserVisiMergeFimist());
		InfoMergerV3<UserInfo, FimistInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<UserInfo> mergeWithUserarch(List<UserInfo> baseInfos, List<UserarchInfo> selectedInfos) {
		InfoMergerBuilderV3<UserInfo, UserarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new UserVisiMergeUserarch());
		InfoMergerV3<UserInfo, UserarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<UserInfo> mergeWithAddress(List<UserInfo> baseInfos, List<AddressInfo> selectedInfos) {
		InfoMergerBuilderV3<UserInfo, AddressInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new UserVisiMergeAddress());
		InfoMergerV3<UserInfo, AddressInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<UserInfo> mergeWithCuspar(List<UserInfo> baseInfos, List<CusparInfo> selectedInfos) {
		InfoMergerBuilderV3<UserInfo, CusparInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new UserVisiMergeCuspar());
		InfoMergerV3<UserInfo, CusparInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<UserInfo> mergeWithAuthgrole(List<UserInfo> baseInfos, List<AuthgroleInfo> selectedInfos) {
		InfoMergerBuilderV3<UserInfo, AuthgroleInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new UserVisiMergeAuthgrole());
		InfoMergerV3<UserInfo, AuthgroleInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<UserInfo> mergeWithPerson(List<UserInfo> baseInfos, List<PersonInfo> selectedInfos) {
		InfoMergerBuilderV3<UserInfo, PersonInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new UserVisiMergePerson());
		InfoMergerV3<UserInfo, PersonInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<UserInfo> mergeWithPhone(List<UserInfo> baseInfos, List<PhoneInfo> selectedInfos) {
		InfoMergerBuilderV3<UserInfo, PhoneInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new UserVisiMergePhone());
		InfoMergerV3<UserInfo, PhoneInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<UserInfo> mergeWithUsername(List<UserInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilderV3<UserInfo, UsernameInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new UserVisiMergeUsername());
		InfoMergerV3<UserInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<UserInfo> mergeWithUserap(List<UserInfo> baseInfos, List<UserapInfo> selectedInfos) {
		InfoMergerBuilderV3<UserInfo, UserapInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new UserVisiMergeUserap());
		InfoMergerV3<UserInfo, UserapInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<UserInfo> mergeToDelete(List<UserInfo> baseInfos, List<UserInfo> selectedInfos) {
		InfoMergerBuilderV3<UserInfo, UserInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new UserVisiMergeToDelete());
		InfoMergerV3<UserInfo, UserInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<UserInfo> mergeToSelect(List<UserInfo> baseInfos, List<UserInfo> selectedInfos) {
		InfoMergerBuilderV3<UserInfo, UserInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new UserVisiMergeToSelect());
		InfoMergerV3<UserInfo, UserInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<UserInfo> mergeToUpdate(List<UserInfo> baseInfos, List<UserInfo> selectedInfos) {
		InfoMergerBuilderV3<UserInfo, UserInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new UserVisiMergeToUpdate());
		InfoMergerV3<UserInfo, UserInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
