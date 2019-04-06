package br.com.gda.security.username.info;


import java.util.List;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.materialMovement.info.MatmovInfo;
import br.com.gda.business.materialStore.info.MatoreInfo;
import br.com.gda.business.materialText.info.MatextInfo;
import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.business.storeLeaveDate.info.StolevateInfo;
import br.com.gda.business.storeWorkTime.info.StowotmInfo;
import br.com.gda.info.InfoCopier;

public final class UsernameCopier {
	public static UsernameInfo copyFromOwner(OwnerInfo source) {
		InfoCopier<UsernameInfo, OwnerInfo> copier = new UsernameCopyOwner();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<UsernameInfo> copyFromOwner(List<OwnerInfo> sources) {
		InfoCopier<UsernameInfo, OwnerInfo> copier = new UsernameCopyOwner();
		return copier.makeCopy(sources);
	}
	
	
	
	public static UsernameInfo copyFromStore(StoreInfo source) {
		InfoCopier<UsernameInfo, StoreInfo> copier = new UsernameCopyStore();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<UsernameInfo> copyFromStore(List<StoreInfo> sources) {
		InfoCopier<UsernameInfo, StoreInfo> copier = new UsernameCopyStore();
		return copier.makeCopy(sources);
	}
	
	
	
	public static UsernameInfo copyFromStowotm(StowotmInfo source) {
		InfoCopier<UsernameInfo, StowotmInfo> copier = new UsernameCopyStowotm();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<UsernameInfo> copyFromStowotm(List<StowotmInfo> sources) {
		InfoCopier<UsernameInfo, StowotmInfo> copier = new UsernameCopyStowotm();
		return copier.makeCopy(sources);
	}
	
	
	
	public static UsernameInfo copyFromStolevate(StolevateInfo source) {
		InfoCopier<UsernameInfo, StolevateInfo> copier = new UsernameCopyStolevate();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<UsernameInfo> copyFromStolevate(List<StolevateInfo> sources) {
		InfoCopier<UsernameInfo, StolevateInfo> copier = new UsernameCopyStolevate();
		return copier.makeCopy(sources);
	}
	
	
	
	public static UsernameInfo copyFromMat(MatInfo source) {
		InfoCopier<UsernameInfo, MatInfo> copier = new UsernameCopyMat();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<UsernameInfo> copyFromMat(List<MatInfo> sources) {
		InfoCopier<UsernameInfo, MatInfo> copier = new UsernameCopyMat();
		return copier.makeCopy(sources);
	}
	
	
	
	public static UsernameInfo copyFromMatmov(MatmovInfo source) {
		InfoCopier<UsernameInfo, MatmovInfo> copier = new UsernameCopyMatmov();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<UsernameInfo> copyFromMatmov(List<MatmovInfo> sources) {
		InfoCopier<UsernameInfo, MatmovInfo> copier = new UsernameCopyMatmov();
		return copier.makeCopy(sources);
	}
	
	
	
	public static UsernameInfo copyFromMatore(MatoreInfo source) {
		InfoCopier<UsernameInfo, MatoreInfo> copier = new UsernameCopyMatore();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<UsernameInfo> copyFromMatore(List<MatoreInfo> sources) {
		InfoCopier<UsernameInfo, MatoreInfo> copier = new UsernameCopyMatore();
		return copier.makeCopy(sources);
	}
	
	
	
	public static UsernameInfo copyFromMatext(MatextInfo source) {
		InfoCopier<UsernameInfo, MatextInfo> copier = new UsernameCopyMatext();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<UsernameInfo> copyFromMatext(List<MatextInfo> sources) {
		InfoCopier<UsernameInfo, MatextInfo> copier = new UsernameCopyMatext();
		return copier.makeCopy(sources);
	}
	
	
	
	public static UsernameInfo copyFromEmp(EmpInfo source) {
		InfoCopier<UsernameInfo, EmpInfo> copier = new UsernameCopyEmp();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<UsernameInfo> copyFromEmp(List<EmpInfo> sources) {
		InfoCopier<UsernameInfo, EmpInfo> copier = new UsernameCopyEmp();
		return copier.makeCopy(sources);
	}
}
