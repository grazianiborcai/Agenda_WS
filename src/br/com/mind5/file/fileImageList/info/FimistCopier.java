package br.com.mind5.file.fileImageList.info;


import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.ownerList.info.OwnelisInfo;
import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.business.storeNearby.info.StorbyInfo;
import br.com.mind5.info.InfoCopier;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.userList.info.UselisInfo;

public final class FimistCopier {
	public static FimistInfo copyFromUselis(UselisInfo source) {
		InfoCopier<FimistInfo, UselisInfo> copier = new FimistCopyUselis();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<FimistInfo> copyFromUselis(List<UselisInfo> sources) {
		InfoCopier<FimistInfo, UselisInfo> copier = new FimistCopyUselis();
		return copier.makeCopy(sources);
	}
	
	
	
	public static FimistInfo copyFromOwnelis(OwnelisInfo source) {
		InfoCopier<FimistInfo, OwnelisInfo> copier = new FimistCopyOwnelis();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<FimistInfo> copyFromOwnelis(List<OwnelisInfo> sources) {
		InfoCopier<FimistInfo, OwnelisInfo> copier = new FimistCopyOwnelis();
		return copier.makeCopy(sources);
	}
	
	
	
	public static FimistInfo copyFromStorby(StorbyInfo source) {
		InfoCopier<FimistInfo, StorbyInfo> copier = new FimistCopyStorby();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<FimistInfo> copyFromStorby(List<StorbyInfo> sources) {
		InfoCopier<FimistInfo, StorbyInfo> copier = new FimistCopyStorby();
		return copier.makeCopy(sources);
	}
	
	
	
	public static FimistInfo copyFromUser(UserInfo source) {
		InfoCopier<FimistInfo, UserInfo> copier = new FimistCopyUser();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<FimistInfo> copyFromUser(List<UserInfo> sources) {
		InfoCopier<FimistInfo, UserInfo> copier = new FimistCopyUser();
		return copier.makeCopy(sources);
	}
	
	
	
	public static FimistInfo copyFromCuslis(CuslisInfo source) {
		InfoCopier<FimistInfo, CuslisInfo> copier = new FimistCopyCuslis();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<FimistInfo> copyFromCuslis(List<CuslisInfo> sources) {
		InfoCopier<FimistInfo, CuslisInfo> copier = new FimistCopyCuslis();
		return copier.makeCopy(sources);
	}
	
	
	
	public static FimistInfo copyFromCus(CusInfo source) {
		InfoCopier<FimistInfo, CusInfo> copier = new FimistCopyCus();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<FimistInfo> copyFromCus(List<CusInfo> sources) {
		InfoCopier<FimistInfo, CusInfo> copier = new FimistCopyCus();
		return copier.makeCopy(sources);
	}
	
	
	
	public static FimistInfo copyFromMat(MatInfo source) {
		InfoCopier<FimistInfo, MatInfo> copier = new FimistCopyMat();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<FimistInfo> copyFromMat(List<MatInfo> sources) {
		InfoCopier<FimistInfo, MatInfo> copier = new FimistCopyMat();
		return copier.makeCopy(sources);
	}	
	
	
	
	public static FimistInfo copyFromMatlis(MatlisInfo source) {
		InfoCopier<FimistInfo, MatlisInfo> copier = new FimistCopyMatlis();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<FimistInfo> copyFromMatlis(List<MatlisInfo> sources) {
		InfoCopier<FimistInfo, MatlisInfo> copier = new FimistCopyMatlis();
		return copier.makeCopy(sources);
	}
	
	
	
	public static FimistInfo copyFromEmplis(EmplisInfo source) {
		InfoCopier<FimistInfo, EmplisInfo> copier = new FimistCopyEmplis();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<FimistInfo> copyFromEmplis(List<EmplisInfo> sources) {
		InfoCopier<FimistInfo, EmplisInfo> copier = new FimistCopyEmplis();
		return copier.makeCopy(sources);
	}	
	
	
	
	public static FimistInfo copyFromEmp(EmpInfo source) {
		InfoCopier<FimistInfo, EmpInfo> copier = new FimistCopyEmp();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<FimistInfo> copyFromEmp(List<EmpInfo> sources) {
		InfoCopier<FimistInfo, EmpInfo> copier = new FimistCopyEmp();
		return copier.makeCopy(sources);
	}
	
	
	
	public static FimistInfo copyFromStolis(StolisInfo source) {
		InfoCopier<FimistInfo, StolisInfo> copier = new FimistCopyStolis();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<FimistInfo> copyFromStolis(List<StolisInfo> sources) {
		InfoCopier<FimistInfo, StolisInfo> copier = new FimistCopyStolis();
		return copier.makeCopy(sources);
	}
	
	
	
	public static FimistInfo copyFromOwner(OwnerInfo source) {
		InfoCopier<FimistInfo, OwnerInfo> copier = new FimistCopyOwner();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<FimistInfo> copyFromOwner(List<OwnerInfo> sources) {
		InfoCopier<FimistInfo, OwnerInfo> copier = new FimistCopyOwner();
		return copier.makeCopy(sources);
	}	
	
	
	
	public static FimistInfo copyFromStore(StoreInfo source) {
		InfoCopier<FimistInfo, StoreInfo> copier = new FimistCopyStore();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<FimistInfo> copyFromStore(List<StoreInfo> sources) {
		InfoCopier<FimistInfo, StoreInfo> copier = new FimistCopyStore();
		return copier.makeCopy(sources);
	}
}
