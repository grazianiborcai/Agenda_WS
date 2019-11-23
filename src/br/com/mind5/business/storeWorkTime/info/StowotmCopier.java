package br.com.mind5.business.storeWorkTime.info;

import java.util.List;

import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.info.InfoCopier;

public final class StowotmCopier {	
	public static StowotmInfo copyFromEmpwotm(EmpwotmInfo source) {
		InfoCopier<StowotmInfo, EmpwotmInfo> copier = new StowotmCopyEmpwotm();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<StowotmInfo> copyFromEmpwotm(List<EmpwotmInfo> sources) {
		InfoCopier<StowotmInfo, EmpwotmInfo> copier = new StowotmCopyEmpwotm();
		return copier.makeCopy(sources);
	}
}
