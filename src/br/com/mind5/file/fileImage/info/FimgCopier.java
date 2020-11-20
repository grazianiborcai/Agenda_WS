package br.com.mind5.file.fileImage.info;

import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.info.InfoCopier;

public final class FimgCopier {	
	public static FimgInfo copyFromEmp(EmpInfo source) {
		InfoCopier<FimgInfo, EmpInfo> copier = new FimgCopyEmp();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<FimgInfo> copyFromEmp(List<EmpInfo> sources) {
		InfoCopier<FimgInfo, EmpInfo> copier = new FimgCopyEmp();
		return copier.makeCopy(sources);
	}	
	
	
	
	public static FimgInfo copyFromOwner(OwnerInfo source) {
		InfoCopier<FimgInfo, OwnerInfo> copier = new FimgCopyOwner();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<FimgInfo> copyFromOwner(List<OwnerInfo> sources) {
		InfoCopier<FimgInfo, OwnerInfo> copier = new FimgCopyOwner();
		return copier.makeCopy(sources);
	}	
}
