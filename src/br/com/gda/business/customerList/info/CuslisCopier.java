package br.com.gda.business.customerList.info;

import java.util.List;

import br.com.gda.business.scheduleWeek.info.SchedeekInfo;
import br.com.gda.info.InfoCopierOneToMany;

public final class CuslisCopier {
	public static List<CuslisInfo> copyFromSchedeek(SchedeekInfo source) {
		InfoCopierOneToMany<CuslisInfo, SchedeekInfo> copier = new CuslisCopySchedeek();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<CuslisInfo> copyFromSchedeek(List<SchedeekInfo> sources) {
		InfoCopierOneToMany<CuslisInfo, SchedeekInfo> copier = new CuslisCopySchedeek();
		return copier.makeCopy(sources);
	}
}
