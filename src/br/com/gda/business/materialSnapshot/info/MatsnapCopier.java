package br.com.gda.business.materialSnapshot.info;

import java.util.List;

import br.com.gda.business.orderItemSnapshot.info.OrdemrapInfo;
import br.com.gda.business.scheduleLineSnapshot.info.SchedinapInfo;
import br.com.gda.info.InfoCopier;

public final class MatsnapCopier {
	public static MatsnapInfo copyFromSchedinap(SchedinapInfo source) {
		InfoCopier<MatsnapInfo, SchedinapInfo> copier = new MatsnapCopySchedinap();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<MatsnapInfo> copyFromSchedinap(List<SchedinapInfo> sources) {
		InfoCopier<MatsnapInfo, SchedinapInfo> copier = new MatsnapCopySchedinap();
		return copier.makeCopy(sources);
	}	
	
	
	
	public static MatsnapInfo copyFromOrdemrap(OrdemrapInfo source) {
		InfoCopier<MatsnapInfo, OrdemrapInfo> copier = new MatsnapCopyOrdemrap();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<MatsnapInfo> copyFromOrdemrap(List<OrdemrapInfo> sources) {
		InfoCopier<MatsnapInfo, OrdemrapInfo> copier = new MatsnapCopyOrdemrap();
		return copier.makeCopy(sources);
	}	
}
