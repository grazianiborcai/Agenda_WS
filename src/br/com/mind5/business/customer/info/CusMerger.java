package br.com.mind5.business.customer.info;


import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.business.customerSnapshot.info.CusnapInfo;
import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class CusMerger {
	public static List<CusInfo> mergeWithFimist(List<CusInfo> baseInfos, List<FimistInfo> selectedInfos) {
		InfoMergerBuilderV3<CusInfo, FimistInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusVisiMergeFimist());
		InfoMergerV3<CusInfo, FimistInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CusInfo> mergeWithCusnap(List<CusInfo> baseInfos, List<CusnapInfo> selectedInfos) {
		InfoMergerBuilderV3<CusInfo, CusnapInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusVisiMergeCusnap());
		InfoMergerV3<CusInfo, CusnapInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CusInfo> mergeWithAddress(List<CusInfo> baseInfos, List<AddressInfo> selectedInfos) {
		InfoMergerBuilderV3<CusInfo, AddressInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusVisiMergeAddress());
		InfoMergerV3<CusInfo, AddressInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CusInfo> mergeWithCusarch(List<CusInfo> baseInfos, List<CusarchInfo> selectedInfos) {
		InfoMergerBuilderV3<CusInfo, CusarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusVisiMergeCusarch());
		InfoMergerV3<CusInfo, CusarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CusInfo> mergeWithPerson(List<CusInfo> baseInfos, List<PersonInfo> selectedInfos) {
		InfoMergerBuilderV3<CusInfo, PersonInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusVisiMergePerson());
		InfoMergerV3<CusInfo, PersonInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CusInfo> mergeWithPhone(List<CusInfo> baseInfos, List<PhoneInfo> selectedInfos) {
		InfoMergerBuilderV3<CusInfo, PhoneInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusVisiMergePhone());
		InfoMergerV3<CusInfo, PhoneInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CusInfo> mergeWithUser(List<CusInfo> baseInfos, List<UserInfo> selectedInfos) {
		InfoMergerBuilderV3<CusInfo, UserInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusVisiMergeUser());
		InfoMergerV3<CusInfo, UserInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CusInfo> mergeWithUsername(List<CusInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilderV3<CusInfo, UsernameInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusVisiMergeUsername());
		InfoMergerV3<CusInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CusInfo> mergeToDelete(List<CusInfo> baseInfos, List<CusInfo> selectedInfos) {
		InfoMergerBuilderV3<CusInfo, CusInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusVisiMergeToDelete());
		InfoMergerV3<CusInfo, CusInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CusInfo> mergeToSelect(List<CusInfo> baseInfos, List<CusInfo> selectedInfos) {
		InfoMergerBuilderV3<CusInfo, CusInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusVisiMergeToSelect());
		InfoMergerV3<CusInfo, CusInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CusInfo> mergeToUpdate(List<CusInfo> baseInfos, List<CusInfo> selectedInfos) {
		InfoMergerBuilderV3<CusInfo, CusInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusVisiMergeToUpdate());
		InfoMergerV3<CusInfo, CusInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
