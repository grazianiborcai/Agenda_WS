package br.com.mind5.business.storeWorkTimeSearch.info;

import java.util.List;

import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.info.InfoCopier;

public final class StowotarchCopier {	
	public static StowotarchInfo copyFromEmpwotm(EmpwotmInfo source) {
		InfoCopier<StowotarchInfo, EmpwotmInfo> copier = new StowotarchCopyEmpwotm();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<StowotarchInfo> copyFromEmpwotm(List<EmpwotmInfo> sources) {
		InfoCopier<StowotarchInfo, EmpwotmInfo> copier = new StowotarchCopyEmpwotm();
		return copier.makeCopy(sources);
	}
}
