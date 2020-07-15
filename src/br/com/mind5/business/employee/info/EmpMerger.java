package br.com.mind5.business.employee.info;

import java.util.List;

import br.com.mind5.authorization.storePartitionAuthorization.info.SytotauhInfo;
import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.employeeSearch.info.EmparchInfo;
import br.com.mind5.business.employeeSnapshot.info.EmpnapInfo;
import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.personSearch.info.PerarchInfo;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.userSearch.info.UserarchInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class EmpMerger {
	public static List<EmpInfo> mergeWithUserarch(List<EmpInfo> baseInfos, List<UserarchInfo> selectedInfos) {
		InfoMergerBuilderV3<EmpInfo, UserarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpVisiMergeUserarch());
		InfoMergerV3<EmpInfo, UserarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmpInfo> mergeWithSytotauh(List<EmpInfo> baseInfos, List<SytotauhInfo> selectedInfos) {
		InfoMergerBuilderV3<EmpInfo, SytotauhInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpVisiMergeSytotauh());
		InfoMergerV3<EmpInfo, SytotauhInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmpInfo> mergeWithEmparch(List<EmpInfo> baseInfos, List<EmparchInfo> selectedInfos) {
		InfoMergerBuilderV3<EmpInfo, EmparchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpVisiMergeEmparch());
		InfoMergerV3<EmpInfo, EmparchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmpInfo> mergeWithPerarch(List<EmpInfo> baseInfos, List<PerarchInfo> selectedInfos) {
		InfoMergerBuilderV3<EmpInfo, PerarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpVisiMergePerarch());
		InfoMergerV3<EmpInfo, PerarchInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<EmpInfo> mergeWithFimist(List<EmpInfo> baseInfos, List<FimistInfo> selectedInfos) {
		InfoMergerBuilderV3<EmpInfo, FimistInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpVisiMergeFimist());
		InfoMergerV3<EmpInfo, FimistInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmpInfo> mergeWithAddress(List<EmpInfo> baseInfos, List<AddressInfo> selectedInfos) {
		InfoMergerBuilderV3<EmpInfo, AddressInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpVisiMergeAddress());
		InfoMergerV3<EmpInfo, AddressInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmpInfo> mergeWithEmpnap(List<EmpInfo> baseInfos, List<EmpnapInfo> selectedInfos) {
		InfoMergerBuilderV3<EmpInfo, EmpnapInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpVisiMergeEmpnap());
		InfoMergerV3<EmpInfo, EmpnapInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmpInfo> mergeWithPerson(List<EmpInfo> baseInfos, List<PersonInfo> selectedInfos) {
		InfoMergerBuilderV3<EmpInfo, PersonInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpVisiMergePerson());
		InfoMergerV3<EmpInfo, PersonInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmpInfo> mergeWithPhone(List<EmpInfo> baseInfos, List<PhoneInfo> selectedInfos) {
		InfoMergerBuilderV3<EmpInfo, PhoneInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpVisiMergePhone());
		InfoMergerV3<EmpInfo, PhoneInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmpInfo> mergeWithUser(List<EmpInfo> baseInfos, List<UserInfo> selectedInfos) {
		InfoMergerBuilderV3<EmpInfo, UserInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpVisiMergeUser());
		InfoMergerV3<EmpInfo, UserInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmpInfo> mergeWithUsername(List<EmpInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilderV3<EmpInfo, UsernameInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpVisiMergeUsername());
		InfoMergerV3<EmpInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmpInfo> mergeToDelete(List<EmpInfo> baseInfos, List<EmpInfo> selectedInfos) {
		InfoMergerBuilderV3<EmpInfo, EmpInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpVisiMergeToDelete());
		InfoMergerV3<EmpInfo, EmpInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmpInfo> mergeToSelect(List<EmpInfo> baseInfos, List<EmpInfo> selectedInfos) {
		InfoMergerBuilderV3<EmpInfo, EmpInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpVisiMergeToSelect());
		InfoMergerV3<EmpInfo, EmpInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmpInfo> mergeToUpdate(List<EmpInfo> baseInfos, List<EmpInfo> selectedInfos) {
		InfoMergerBuilderV3<EmpInfo, EmpInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpVisiMergeToUpdate());
		InfoMergerV3<EmpInfo, EmpInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
