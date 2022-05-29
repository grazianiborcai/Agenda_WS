package br.com.mind5.security.user.info;

import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.masterData.authorizationGroupRole.info.AuthgroleInfo;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.security.userSearch.info.UserarchInfo;
import br.com.mind5.security.userSnapshot.info.UserapInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class UserMerger {
	public static List<UserInfo> mergeWithFimist(List<UserInfo> baseInfos, List<FimistInfo> selectedInfos) {
		InfoMergerBuilder<UserInfo, FimistInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new UserMergerVisiFimist());
		InfoMerger<UserInfo, FimistInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<UserInfo> mergeWithUserarch(List<UserInfo> baseInfos, List<UserarchInfo> selectedInfos) {
		InfoMergerBuilder<UserInfo, UserarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new UserMergerVisiUserarch());
		InfoMerger<UserInfo, UserarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<UserInfo> mergeWithAddress(List<UserInfo> baseInfos, List<AddressInfo> selectedInfos) {
		InfoMergerBuilder<UserInfo, AddressInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new UserMergerVisiAddress());
		InfoMerger<UserInfo, AddressInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<UserInfo> mergeWithCuspar(List<UserInfo> baseInfos, List<CusparInfo> selectedInfos) {
		InfoMergerBuilder<UserInfo, CusparInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new UserMergerVisiCuspar());
		InfoMerger<UserInfo, CusparInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<UserInfo> mergeWithAuthgrole(List<UserInfo> baseInfos, List<AuthgroleInfo> selectedInfos) {
		InfoMergerBuilder<UserInfo, AuthgroleInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new UserMergerVisiAuthgrole());
		InfoMerger<UserInfo, AuthgroleInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<UserInfo> mergeWithPerson(List<UserInfo> baseInfos, List<PersonInfo> selectedInfos) {
		InfoMergerBuilder<UserInfo, PersonInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new UserMergerVisiPerson());
		InfoMerger<UserInfo, PersonInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<UserInfo> mergeWithPhone(List<UserInfo> baseInfos, List<PhoneInfo> selectedInfos) {
		InfoMergerBuilder<UserInfo, PhoneInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new UserMergerVisiPhone());
		InfoMerger<UserInfo, PhoneInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<UserInfo> mergeWithUsername(List<UserInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilder<UserInfo, UsernameInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new UserMergerVisiUsername());
		InfoMerger<UserInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<UserInfo> mergeWithUserap(List<UserInfo> baseInfos, List<UserapInfo> selectedInfos) {
		InfoMergerBuilder<UserInfo, UserapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new UserMergerVisiUserap());
		InfoMerger<UserInfo, UserapInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<UserInfo> mergeToDelete(List<UserInfo> baseInfos, List<UserInfo> selectedInfos) {
		InfoMergerBuilder<UserInfo, UserInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new UserMergerVisiToDelete());
		InfoMerger<UserInfo, UserInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<UserInfo> mergeToSelect(List<UserInfo> baseInfos, List<UserInfo> selectedInfos) {
		InfoMergerBuilder<UserInfo, UserInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new UserMergerVisiToSelect());
		InfoMerger<UserInfo, UserInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<UserInfo> mergeToUpdate(List<UserInfo> baseInfos, List<UserInfo> selectedInfos) {
		InfoMergerBuilder<UserInfo, UserInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new UserMergerVisiToUpdate());
		InfoMerger<UserInfo, UserInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
